package com.senai.cantina.cantina.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.senai.cantina.cantina.model.Pagamento;

public record PagamentoResponse(
        Long id,
        Long pedidoId,
        Pagamento.FormaPagamento formaPagamento,
        Pagamento.StatusPagamento status,
        BigDecimal valor,
        LocalDateTime dataHoraPagamento,
        String codigoTransacao
) {
    public static PagamentoResponse from(Pagamento pagamento) {
        return new PagamentoResponse(
                pagamento.getId(),
                pagamento.getPedido().getId(),
                pagamento.getFormaPagamento(),
                pagamento.getStatus(),
                pagamento.getValor(),
                pagamento.getDataHoraPagamento(),
                pagamento.getCodigoTransacao()
        );
    }
}
