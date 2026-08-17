package com.senai.cantina.cantina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.cantina.cantina.model.Comentario;

public interface ComentarioRepository
        extends JpaRepository<Comentario, Long> {

    List<Comentario> findByAvaliacao(int avaliacao);

    List<Comentario> findAllByOrderByDataHoraComentarioDesc();

    @Query("""
            SELECT c FROM Comentario c
            WHERE LOWER(c.comentarioUsuario)
            LIKE LOWER(CONCAT('%', :texto, '%'))
            """)
    List<Comentario> buscarPorTexto(@Param("texto") String texto);
}