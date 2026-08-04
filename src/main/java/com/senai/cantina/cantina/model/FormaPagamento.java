package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue
    private Long idFormaPagamento;
    private Enum tipoFormaPagamento;

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Enum getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(Enum tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    public FormaPagamento(){

    }

    public FormaPagamento(Long idFormaPagamento, Enum tipoFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        FormaPagamento that = (FormaPagamento) o;
        return idFormaPagamento != null && idFormaPagamento.equals(that.idFormaPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    public enum TipoFormaPagamento{
        DEBITO("Débito"),
        CREDITO("Crédito"),
        PIX("Pix"),
        DINHEIRO("Dinheiro");
        }

}
