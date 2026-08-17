package com.senai.cantina.cantina.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cantina.cantina.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    List<Login> findByDataCriacao(LocalDate dataCriacao);

    List<Login> findAllByOrderByUltimoAcessoDesc();
}