package com.senai.cantina.cantina.dto;

import java.math.BigDecimal;

import com.senai.cantina.cantina.model.Produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProdutoRequest(
        @NotBlank @Size(min = 2, max = 100) String nome,
        @Size(max = 500) String descricao,
        @NotNull Produto.CategoriaProduto categoria,
        @NotNull @DecimalMin("0.00") BigDecimal precoCusto,
        @NotNull @DecimalMin("0.01") BigDecimal precoVenda,
        @PositiveOrZero int estoqueMinimo,
        boolean perecivel
) {
    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setCategoria(categoria);
        produto.setPrecoCusto(precoCusto);
        produto.setPrecoVenda(precoVenda);
        produto.setEstoqueMinimo(estoqueMinimo);
        produto.setPerecivel(perecivel);
        return produto;
    }
}
