package com.senai.cantina.cantina.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @NotNull(message = "Data e hora do comentário são obrigatórias")
    @Column(nullable = false)
    private LocalDateTime dataHoraComentario;

    @NotBlank(message = "Comentário é obrigatório")
    @Size(max = 500,
            message = "Comentário deve conter no máximo 500 caracteres")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String comentarioUsuario;

    @Min(value = 1, message = "Avaliação mínima é 1")
    @Max(value = 5, message = "Avaliação máxima é 5")
    @Column(nullable = false)
    private int avaliacao;

    // MÉTODO CONSTRUTOR

    public Comentario() {
    }

    // GETTERS E SETTERS

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

    // EQUALS E HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Comentario comentario = (Comentario) o;

        return idComentario != null
                && idComentario.equals(comentario.idComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}