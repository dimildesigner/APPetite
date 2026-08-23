package com.senai.cantina.cantina.dto;

import java.math.BigDecimal;

import com.senai.cantina.cantina.model.ItemPedido;

public record ItemPedidoResponse(
        Long id,
        ProdutoResponse produto,
        int quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal
) {
    public static ItemPedidoResponse from(ItemPedido item) {
        return new ItemPedidoResponse(
                item.getId(),
                ProdutoResponse.from(item.getProduto()),
                item.getQuantidade(),
                item.getPrecoUnitario(),
                item.getSubtotal()
        );
    }
}
