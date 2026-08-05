package com.senai.cantina.cantina.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Login {

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
