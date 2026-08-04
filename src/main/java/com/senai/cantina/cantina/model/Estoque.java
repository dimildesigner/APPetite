package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue
    private Long idEstoque;
    private Enum tipoEstoque;
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

    public Enum getTipoEstoque() {
        return tipoEstoque;
    }

    public void setTipoEstoque(Enum tipoEstoque) {
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

    public Estoque(){

    }
    public Estoque(Long idEstoque, Enum tipo, String origem, int quantidade, double saldo_anterior, double saldo_atual, LocalDateTime data_movimentacao) {
        this.idEstoque = idEstoque;
        this.tipoEstoque = tipoEstoque;
        this.origem = origem;
        this.quantidadeEstoque = quantidadeEstoque;
        this.saldoAnterior = saldo_anterior;
        this.saldoAtual = saldo_atual;
        this.dataMovimentacao = data_movimentacao;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Estoque that = (Estoque) o;
        return idEstoque!= null && idEstoque.equals(that.idEstoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
