package com.senai.cantina.cantina.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.senai.cantina.cantina.model.Pedido;

public record PedidoResponse(
        Long id,
        UsuarioResponse usuario,
        LocalDateTime dataHoraPedido,
        LocalDateTime horarioRetirada,
        Pedido.TipoPedido tipoPedido,
        BigDecimal valorTotal,
        Pedido.StatusPedido status,
        String observacao,
        String codigoRetirada,
        List<ItemPedidoResponse> itens
) {
    public static PedidoResponse from(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                UsuarioResponse.from(pedido.getUsuario()),
                pedido.getDataHoraPedido(),
                pedido.getHorarioRetirada(),
                pedido.getTipoPedido(),
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.getObservacao(),
                pedido.getCodigoRetirada(),
                pedido.getItens().stream()
                        .map(ItemPedidoResponse::from)
                        .toList()
        );
    }
}
