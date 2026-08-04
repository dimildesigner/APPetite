package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue
    private Long idFornecedor;
    private String nomeFornecedor;
    private String cnpj;
    private boolean FornecedorAtivo;

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isFornecedorAtivo() {
        return FornecedorAtivo;
    }

    public void setFornecedorAtivo(boolean fornecedorAtivo) {
        FornecedorAtivo = fornecedorAtivo;
    }

    public Fornecedor() {

    }

    public Fornecedor(Long idFornecedor, String nomeFornecedor, String cnpj, boolean fornecedorAtivo) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        FornecedorAtivo = fornecedorAtivo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return FornecedorAtivo == that.FornecedorAtivo && Objects.equals(idFornecedor, that.idFornecedor) && Objects.equals(nomeFornecedor, that.nomeFornecedor) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
