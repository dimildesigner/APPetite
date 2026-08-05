package com.senai.cantina.cantina.model;

import java.util.Objects;

public class Produto {
    private Long idProduto;
    private String nomeProduto;
    private double precoCusto;
    private double margemLucro;
    private double precoVenda;
    private int estoqueAtual;
    private int estoqueMinimo;
    private boolean produtoAtivo;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public boolean isProdutoAtivo() {
        return produtoAtivo;
    }

    public void setProdutoAtivo(boolean produtoAtivo) {
        this.produtoAtivo = produtoAtivo;
    }

    public Produto(){

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(precoCusto, produto.precoCusto) == 0 && Double.compare(margemLucro, produto.margemLucro) == 0 && Double.compare(precoVenda, produto.precoVenda) == 0 && estoqueAtual == produto.estoqueAtual && estoqueMinimo == produto.estoqueMinimo && produtoAtivo == produto.produtoAtivo && Objects.equals(idProduto, produto.idProduto) && Objects.equals(nomeProduto, produto.nomeProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
