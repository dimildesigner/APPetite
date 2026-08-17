package com.senai.cantina.cantina.model;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @NotBlank(message = "Nome do funcionário é obrigatório")
    @Size(min = 3, max = 100,
            message = "Nome deve conter entre 3 e 100 caracteres")
    @Column(nullable = false)
    private String nomeFuncionario;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14,
            message = "Informe um CPF válido")
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @NotNull(message = "Cargo é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Cargo cargo;

    @Column(nullable = false)
    private boolean funcionarioAtivo;

    // MÉTODO CONSTRUTOR

    public Funcionario() {
    }

    // GETTERS E SETTERS

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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isFuncionarioAtivo() {
        return funcionarioAtivo;
    }

    public void setFuncionarioAtivo(boolean funcionarioAtivo) {
        this.funcionarioAtivo = funcionarioAtivo;
    }

    // EQUALS E HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Funcionario funcionario = (Funcionario) o;

        return idFuncionario != null
                && idFuncionario.equals(funcionario.idFuncionario);
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