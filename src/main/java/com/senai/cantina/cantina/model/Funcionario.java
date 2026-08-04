package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue
    private Long idFuncionario;
    private String nomeFuncionario;
    private String cpf;
    private Enum cargo;
    private boolean funcionarioAtivo;

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }

    public Funcionario() {

    }

    public Funcionario(Long idFuncionario, String nomeFuncionario, String cpf, Enum cargo, boolean funcionarioAtivo) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
        this.cargo = cargo;
        this.funcionarioAtivo = funcionarioAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return funcionarioAtivo == that.funcionarioAtivo && Objects.equals(idFuncionario, that.idFuncionario) && Objects.equals(nomeFuncionario, that.nomeFuncionario) && Objects.equals(cpf, that.cpf) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}