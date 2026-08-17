package com.senai.cantina.cantina.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.cantina.cantina.model.Funcionario;
import com.senai.cantina.cantina.model.Funcionario.Cargo;

public interface FuncionarioRepository
        extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);

    List<Funcionario> findByCargo(Cargo cargo);

    List<Funcionario> findByFuncionarioAtivo(boolean funcionarioAtivo);

    @Query("""
            SELECT f FROM Funcionario f
            WHERE LOWER(f.nomeFuncionario)
            LIKE LOWER(CONCAT('%', :nome, '%'))
            """)
    List<Funcionario> buscarPorNome(@Param("nome") String nome);
}