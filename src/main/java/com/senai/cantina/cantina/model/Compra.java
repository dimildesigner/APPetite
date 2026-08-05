package com.senai.cantina.cantina.model;

import java.time.LocalDate;
import java.util.Objects;

public class Compra {

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


