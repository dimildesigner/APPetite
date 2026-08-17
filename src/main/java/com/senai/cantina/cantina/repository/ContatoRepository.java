package com.senai.cantina.cantina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cantina.cantina.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Optional<Contato> findByEmail(String email);

    Optional<Contato> findByTelefone(String telefone);
}