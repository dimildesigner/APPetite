package com.senai.cantina.cantina.model;


import java.util.Objects;


public class Contato {


    private Long idContato;
    private String email;
    private String telefone;

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Contato(){

    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Contato that = (Contato) o;
        return idContato != null && idContato.equals(that.idContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}
