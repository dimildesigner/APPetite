package com.senai.cantina.cantina.model;


import java.util.Objects;

public class Funcionario {
    private Long idFuncionario;
    private String nomeFuncionario;
    private String cpf;
    private String cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario() {

    }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Funcionario that = (Funcionario) o;
            return idFuncionario != null && idFuncionario.equals(that.idFuncionario);
        }

        @Override
        public int hashCode() {
            return Objects.hash(getClass());
        }

    public enum Cargo {
        GERENTE("Gerente"),
        BALCONISTA("Balconista"),
        CHAPEIRO("Chapeiro");

        private final String funcao;

        Cargo(String funcao) {
            this.funcao = funcao;
        }

        public String getFuncao() {
            return funcao;
        }
    }
}

