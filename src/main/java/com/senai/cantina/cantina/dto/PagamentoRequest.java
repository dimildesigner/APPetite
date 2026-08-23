package com.senai.cantina.cantina.dto;

import com.senai.cantina.cantina.model.Pagamento.FormaPagamento;

import jakarta.validation.constraints.NotNull;

public record PagamentoRequest(
        @NotNull FormaPagamento formaPagamento
) {
}
