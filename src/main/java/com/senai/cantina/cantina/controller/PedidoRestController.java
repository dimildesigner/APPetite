package com.senai.cantina.cantina.controller;

import java.security.Principal;
import java.util.List;

import com.senai.cantina.cantina.dto.ItemPedidoRequest;
import com.senai.cantina.cantina.dto.PedidoRequest;
import com.senai.cantina.cantina.dto.PedidoResponse;
import com.senai.cantina.cantina.model.Pedido;
import com.senai.cantina.cantina.model.Usuario;
import com.senai.cantina.cantina.service.PedidoService;
import com.senai.cantina.cantina.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {

    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PedidoRestController(
            PedidoService pedidoService,
            UsuarioService usuarioService
    ) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/meus")
    public List<PedidoResponse> meus(Principal principal) {
        Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
        return pedidoService.listarPorUsuario(usuario.getId()).stream()
                .map(PedidoResponse::from).toList();
    }

    @GetMapping("/{id}")
    public PedidoResponse buscar(
            @PathVariable Long id,
            Principal principal
    ) {
        Pedido pedido = pedidoService.buscarPorId(id);
        verificarAcesso(pedido, principal);
        return PedidoResponse.from(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(
            @Valid @RequestBody PedidoRequest request,
            Principal principal
    ) {
        Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
        Pedido dados = new Pedido();
        dados.setTipoPedido(request.tipoPedido());
        dados.setHorarioRetirada(request.horarioRetirada());
        dados.setObservacao(request.observacao());
        Pedido criado = pedidoService.criar(usuario.getId(), dados);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PedidoResponse.from(criado));
    }

    @PostMapping("/{id}/itens")
    public PedidoResponse adicionarItem(
            @PathVariable Long id,
            @Valid @RequestBody ItemPedidoRequest request,
            Principal principal
    ) {
        verificarAcesso(pedidoService.buscarPorId(id), principal);
        return PedidoResponse.from(pedidoService.adicionarItem(
                id, request.produtoId(), request.quantidade()
        ));
    }

    @PutMapping("/{id}/itens/{itemId}")
    public PedidoResponse alterarQuantidade(
            @PathVariable Long id,
            @PathVariable Long itemId,
            @Valid @RequestBody ItemPedidoRequest request,
            Principal principal
    ) {
        verificarAcesso(pedidoService.buscarPorId(id), principal);
        return PedidoResponse.from(pedidoService.alterarQuantidade(
                id, itemId, request.quantidade()
        ));
    }

    @DeleteMapping("/{id}/itens/{itemId}")
    public PedidoResponse removerItem(
            @PathVariable Long id,
            @PathVariable Long itemId,
            Principal principal
    ) {
        verificarAcesso(pedidoService.buscarPorId(id), principal);
        return PedidoResponse.from(pedidoService.removerItem(id, itemId));
    }

    @PostMapping("/{id}/confirmar")
    public PedidoResponse confirmar(
            @PathVariable Long id,
            Principal principal
    ) {
        verificarAcesso(pedidoService.buscarPorId(id), principal);
        return PedidoResponse.from(pedidoService.confirmarPedido(id));
    }

    private void verificarAcesso(Pedido pedido, Principal principal) {
        Usuario usuario = usuarioService.buscarPorEmail(principal.getName());
        boolean eDono = pedido.getUsuario().getId().equals(usuario.getId());
        boolean eEquipe = usuario.getTipoUsuario() != Usuario.TipoUsuario.CLIENTE;
        if (!eDono && !eEquipe) {
            throw new AccessDeniedException("Você não tem acesso a este pedido.");
        }
    }
}
