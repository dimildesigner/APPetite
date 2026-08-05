package com.senai.cantina.cantina.model;


import java.util.Objects;

public class FormaPagamento {

    private Long idFormaPagamento;
    private String tipoFormaPagamento;

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(String tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }

    public FormaPagamento(){

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

        private final String formapagamento;

        TipoFormaPagamento(String formapagamento) {
            this.formapagamento = formapagamento;
        }

        public String getFormapagamento() {
            return formapagamento;
        }
        }

}
