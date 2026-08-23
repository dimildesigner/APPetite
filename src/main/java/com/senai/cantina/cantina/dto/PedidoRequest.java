package com.senai.cantina.cantina.dto;

import java.time.LocalDateTime;

import com.senai.cantina.cantina.model.Pedido.TipoPedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PedidoRequest(
        @NotNull TipoPedido tipoPedido,
        LocalDateTime horarioRetirada,
        @Size(max = 500) String observacao
) {
}
