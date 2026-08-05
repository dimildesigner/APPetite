package com.senai.cantina.cantina.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pedido {

    private Long idPedido;
    private LocalDate dataPedido;
    private double valorTotal;
    private String statusPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Pedido(){

    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Pedido that = (Pedido) o;
        return idPedido != null && idPedido.equals(that.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}
