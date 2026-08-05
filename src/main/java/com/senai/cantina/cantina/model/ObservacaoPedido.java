package com.senai.cantina.cantina.model;


import java.util.Objects;

public class ObservacaoPedido {

    private Long idObservacaoPedido;
    private String observacaoUsuario;

    public String getObservacaoUsuario() {
        return observacaoUsuario;
    }

    public void setObservacaoUsuario(String observacaoUsuario) {
        this.observacaoUsuario = observacaoUsuario;
    }

    public Long getIdObservacaoPedido() {
        return idObservacaoPedido;
    }

    public void setIdObservacaoPedido(Long idObservacaoPedido) {
        this.idObservacaoPedido = idObservacaoPedido;
    }

    public ObservacaoPedido(){

    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        ObservacaoPedido that = (ObservacaoPedido) o;
        return idObservacaoPedido != null && idObservacaoPedido.equals(that.idObservacaoPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}