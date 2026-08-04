package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Contato {

    @Id
    @GeneratedValue
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

    public Contato(Long idContato, String email, String telefone) {
        this.idContato = idContato;
        this.email = email;
        this.telefone = telefone;
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
