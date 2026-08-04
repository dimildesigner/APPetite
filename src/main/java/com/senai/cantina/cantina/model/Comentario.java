package com.senai.cantina.cantina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Comentario {

    @Id
    @GeneratedValue
    private Long idComentario;
    private LocalDateTime dataHoraComentario;
    private String comentarioUsuario;
    private int avaliacao;

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public LocalDateTime getDataHoraComentario() {
        return dataHoraComentario;
    }

    public void setDataHoraComentario(LocalDateTime dataHoraComentario) {
        this.dataHoraComentario = dataHoraComentario;
    }

    public String getComentarioUsuario() {
        return comentarioUsuario;
    }

    public void setComentarioUsuario(String comentarioUsuario) {
        this.comentarioUsuario = comentarioUsuario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Comentario(){

    }

    public Comentario(Long idComentario, LocalDateTime dataHoraComentario, String comentarioUsuario, int avaliacao) {
        this.idComentario = idComentario;
        this.dataHoraComentario = dataHoraComentario;
        this.comentarioUsuario = comentarioUsuario;
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Comentario that = (Comentario) o;
        return idComentario != null && idComentario.equals(that.idComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}