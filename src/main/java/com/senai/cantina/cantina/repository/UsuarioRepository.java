package com.senai.cantina.cantina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.cantina.cantina.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByTipoUsuario(String tipoUsuario);

    @Query("""
            SELECT u FROM Usuario u
            WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
            """)
    List<Usuario> buscarPorNome(@Param("nome") String nome);
}