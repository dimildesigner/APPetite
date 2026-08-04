package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ItemCompra {
    @Id
    @GeneratedValue
    private Long idItemCompra;
    private int quantidadeCompra;
    private double precoUnitario;
    private double subtotal;

    public Long getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(Long idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public int getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ItemCompra(){

    }

    public ItemCompra(Long idItemCompra, int quantidadeCompra, double precoUnitario, double subtotal) {
        this.idItemCompra = idItemCompra;
        this.quantidadeCompra = quantidadeCompra;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCompra that = (ItemCompra) o;
        return quantidadeCompra == that.quantidadeCompra && Double.compare(precoUnitario, that.precoUnitario) == 0 && Double.compare(subtotal, that.subtotal) == 0 && Objects.equals(idItemCompra, that.idItemCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
