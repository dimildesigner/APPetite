package com.senai.cantina.cantina.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.senai.cantina.cantina.model.Pedido;
import com.senai.cantina.cantina.model.Pedido.StatusPedido;
import com.senai.cantina.cantina.model.Pedido.TipoPedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuarioIdOrderByDataHoraPedidoDesc(
            Long usuarioId
    );

    List<Pedido> findByStatus(
            StatusPedido status
    );

    List<Pedido> findByTipoPedido(
            TipoPedido tipoPedido
    );

    List<Pedido> findByStatusAndTipoPedido(
            StatusPedido status,
            TipoPedido tipoPedido
    );

    List<Pedido> findByDataHoraPedidoBetween(
            LocalDateTime inicio,
            LocalDateTime fim
    );

    Optional<Pedido> findByCodigoRetirada(
            String codigoRetirada
    );

    @EntityGraph(
            attributePaths = {
                    "usuario",
                    "itens",
                    "itens.produto"
            }
    )
    @Query("""
        SELECT p
        FROM Pedido p
        WHERE p.id = :id
        """)
    Optional<Pedido> buscarCompletoPorId(
            @Param("id") Long id
    );
}