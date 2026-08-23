package com.senai.cantina.cantina.dto;

import java.math.BigDecimal;

import com.senai.cantina.cantina.model.Produto;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        Produto.CategoriaProduto categoria,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        int estoqueAtual,
        int estoqueMinimo,
        boolean perecivel,
        boolean ativo
) {
    public static ProdutoResponse from(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda(),
                produto.getEstoqueAtual(),
                produto.getEstoqueMinimo(),
                produto.isPerecivel(),
                produto.isAtivo()
        );
    }
}
