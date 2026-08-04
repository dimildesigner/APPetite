package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class VendaPagamento {
    @Id
    @GeneratedValue
    private Long idVendaPagamento;
    private double valor;

    public Long getIdVendaPagamento() {
        return idVendaPagamento;
    }

    public void setIdVendaPagamento(Long idVendaPagamento) {
        this.idVendaPagamento = idVendaPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public VendaPagamento(){

    }

    public VendaPagamento(Long idVendaPagamento, double valor) {
        this.idVendaPagamento = idVendaPagamento;
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VendaPagamento that = (VendaPagamento) o;
        return Double.compare(valor, that.valor) == 0 && Objects.equals(idVendaPagamento, that.idVendaPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
