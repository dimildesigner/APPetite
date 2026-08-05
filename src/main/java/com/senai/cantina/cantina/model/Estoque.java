package com.senai.cantina.cantina.model;


import java.time.LocalDateTime;
import java.util.Objects;

public class Estoque {
    private Long idEstoque;
    private String tipoEstoque;
    private String origem;
    private int quantidadeEstoque;
    private double saldoAnterior;
    private double saldoAtual;
    private LocalDateTime dataMovimentacao;

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getTipoEstoque() {
        return tipoEstoque;
    }

    public void setTipoEstoque(String tipoEstoque) {
        this.tipoEstoque = tipoEstoque;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Estoque() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Estoque that = (Estoque) o;
        return idEstoque != null && idEstoque.equals(that.idEstoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    public enum TipoEstoque {
        PERECIVEL("Perecível"),
        NAO_PERECIVEL("Não Perecível"),
        OUTROS("Outros");

        private final String categoriaEstoque;

        TipoEstoque(String categoriaEstoque) {
            this.categoriaEstoque = categoriaEstoque;
        }

        public String getCategoriaEstoque() {
            return categoriaEstoque;
        }
    }
}
