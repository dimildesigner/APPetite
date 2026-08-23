package com.senai.cantina.cantina.controller;

import java.util.List;

import com.senai.cantina.cantina.dto.ProdutoRequest;
import com.senai.cantina.cantina.dto.ProdutoResponse;
import com.senai.cantina.cantina.model.Produto.CategoriaProduto;
import com.senai.cantina.cantina.service.ProdutoService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRestController {

    private final ProdutoService produtoService;

    public ProdutoRestController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoResponse> listar(
            @RequestParam(required = false) Boolean ativo,
            @RequestParam(required = false) CategoriaProduto categoria,
            @RequestParam(required = false) String nome
    ) {
        if (Boolean.FALSE.equals(ativo)) {
            return produtoService.listarTodos().stream()
                    .map(ProdutoResponse::from).toList();
        }

        return produtoService.filtrar(categoria, nome).stream()
                .map(ProdutoResponse::from).toList();
    }

    @GetMapping("/{id}")
    public ProdutoResponse buscar(@PathVariable Long id) {
        return ProdutoResponse.from(produtoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(
            @Valid @RequestBody ProdutoRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProdutoResponse.from(produtoService.cadastrar(request.toEntity())));
    }

    @PutMapping("/{id}")
    public ProdutoResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequest request
    ) {
        return ProdutoResponse.from(
                produtoService.atualizar(id, request.toEntity())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.alterarStatus(id, false);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    public ProdutoResponse alterarStatus(
            @PathVariable Long id,
            @RequestParam boolean ativo
    ) {
        produtoService.alterarStatus(id, ativo);
        return ProdutoResponse.from(produtoService.buscarPorId(id));
    }
}
