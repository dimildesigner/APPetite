package com.senai.cantina.cantina.model;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContato;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "Informe um e-mail válido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 10, max = 20,
            message = "Informe um telefone válido")
    @Column(nullable = false, length = 20)
    private String telefone;

    // MÉTODO CONSTRUTOR

    public Contato() {
    }

    // GETTERS E SETTERS

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

    // EQUALS E HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Contato contato = (Contato) o;

        return idContato != null
                && idContato.equals(contato.idContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}