package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Long idCompra;
    private LocalDate dataCompra;
    private double valorTotalCompra;
    private String observacao;

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Compra(){

    }

    public Compra(Long idCompra, LocalDate dataCompra, double valorTotalCompra, String observacao) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
        this.valorTotalCompra = valorTotalCompra;
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Compra that = (Compra) o;
        return idCompra != null && idCompra.equals(that.idCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}


