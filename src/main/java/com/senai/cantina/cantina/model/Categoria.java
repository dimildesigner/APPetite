package com.senai.cantina.cantina.model;


import java.util.Objects;

public class Categoria {

    private Long idCategoria;
    private String nomeCategoria;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(){

    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Categoria that = (Categoria) o;
        return idCategoria != null && idCategoria.equals(that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

    public enum CategoriaProduto {

        LANCHE("Lanche"),
        SALGADO("Salgado"),
        SNACK("Snack e Porção"),
        BEBIDA("Bebida"),
        SOBREMESA("Sobremesa"),
        ADICIONAL("Adicional"),
        OUTROS("Outros");

        private final String descricao;

        CategoriaProduto(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
