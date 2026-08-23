package com.senai.cantina.cantina.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemPedidoRequest(
        @NotNull Long produtoId,
        @Positive int quantidade
) {
}
