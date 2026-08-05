package com.senai.cantina.cantina.model;


import java.util.Objects;

public class ItemPedido {
    private Long idItemPedido;
    private int quantidadePedido;
    private double precoUnitarioPedido;
    private double subtotalPedido;

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQuantidadePedido() {
        return quantidadePedido;
    }

    public void setQuantidadePedido(int quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public double getPrecoUnitarioPedido() {
        return precoUnitarioPedido;
    }

    public void setPrecoUnitarioPedido(double precoUnitarioPedido) {
        this.precoUnitarioPedido = precoUnitarioPedido;
    }

    public double getSubtotalPedido() {
        return subtotalPedido;
    }

    public void setSubtotalPedido(double subtotalPedido) {
        this.subtotalPedido = subtotalPedido;
    }

    public ItemPedido(){

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return quantidadePedido == that.quantidadePedido && Double.compare(precoUnitarioPedido, that.precoUnitarioPedido) == 0 && Double.compare(subtotalPedido, that.subtotalPedido) == 0 && Objects.equals(idItemPedido, that.idItemPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
