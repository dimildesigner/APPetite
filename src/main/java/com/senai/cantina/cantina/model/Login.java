package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Login {

    @Id
    @GeneratedValue
    private Long idLogin;
    private LocalDateTime ultimoAcesso;
    private LocalDate dataCriacao;
    private String senha;

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

    public Login(){

    }

    public Login(Long idLogin, LocalDateTime ultimoAcesso, LocalDate dataCriacao, String senha) {
        this.idLogin = idLogin;
        this.ultimoAcesso = ultimoAcesso;
        this.dataCriacao = dataCriacao;
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Login that = (Login) o;
        return idLogin != null && idLogin.equals(that.idLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}
