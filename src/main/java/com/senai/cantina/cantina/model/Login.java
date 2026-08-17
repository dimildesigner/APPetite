package com.senai.cantina.cantina.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "logins")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column
    private LocalDateTime ultimoAcesso;

    @NotNull(message = "Data de criação é obrigatória")
    @Column(nullable = false)
    private LocalDate dataCriacao;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 100,
            message = "A senha deve conter entre 6 e 100 caracteres")
    @Column(nullable = false)
    private String senha;

    // MÉTODO CONSTRUTOR

    public Login() {
    }

    // GETTERS E SETTERS

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // EQUALS E HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Login login = (Login) o;
        return idLogin != null && idLogin.equals(login.idLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}