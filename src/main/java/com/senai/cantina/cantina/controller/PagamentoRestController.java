package com.senai.cantina.cantina.controller;

import java.security.Principal;

import com.senai.cantina.cantina.dto.PagamentoRequest;
import com.senai.cantina.cantina.dto.PagamentoResponse;
import com.senai.cantina.cantina.model.Pagamento;
import com.senai.cantina.cantina.model.Pedido;
import com.senai.cantina.cantina.model.Usuario;
import com.senai.cantina.cantina.service.PagamentoService;
import com.senai.cantina.cantina.service.PedidoService;
import com.senai.cantina.cantina.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoRestController {

    private final PagamentoService pagamentoService;
    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PagamentoRestController(
            PagamentoService pagamentoService,
            PedidoService pedidoService,
            UsuarioService usuarioService
    ) {
        this.pagamentoService = pagamentoService;
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public PagamentoResponse buscar(
            @PathVariable Long id,
            Principal principal
    ) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        verificarAcesso(pagamento.getPedido(), principal);
        return PagamentoResponse.from(pagamento);
    }

    @PostMapping("/pedido/{pedidoId}")
    public PagamentoResponse iniciar(
            @PathVariable Long pedidoId,
            @Valid @RequestBody PagamentoRequest request,
            Principal principal
    ) {
        verificarAcesso(pedidoService.buscarPorId(pedidoId), principal);
        return PagamentoResponse.from(pagamentoService.iniciarPagamento(
                pedidoId, request.formaPagamento()
        ));
    }

    @PostMapping("/{id}/aprovar")
    public PagamentoResponse aprovar(@PathVariable Long id, Principal principal) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        verificarAcesso(pagamento.getPedido(), principal);
        return PagamentoResponse.from(pagamentoService.aprovar(id));
    }

    @PostMapping("/{id}/cancelar")
    public PagamentoResponse cancelar(@PathVariable Long id, Principal principal) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        verificarAcesso(pagamento.getPedido(), principal);
        return PagamentoResponse.from(pagamentoService.cancelarPendente(id));
    }

    private void verificarAcesso(Pedido pedido, Principal principal) {
        Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
        boolean eDono = pedido.getUsuario().getId().equals(usuario.getId());
        boolean eEquipe = usuario.getTipoUsuario() != Usuario.TipoUsuario.CLIENTE;
        if (!eDono && !eEquipe) {
            throw new AccessDeniedException("Você não tem acesso a este pagamento.");
        }
    }
}
