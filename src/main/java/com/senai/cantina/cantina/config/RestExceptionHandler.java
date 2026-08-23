package com.senai.cantina.cantina.config;

import java.util.Map;

import com.senai.cantina.cantina.controller.PagamentoRestController;
import com.senai.cantina.cantina.controller.PedidoRestController;
import com.senai.cantina.cantina.controller.ProdutoRestController;
import com.senai.cantina.cantina.exception.RecursoNaoEncontradoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {
        ProdutoRestController.class,
        PedidoRestController.class,
        PagamentoRestController.class
})
public class RestExceptionHandler {

        @ExceptionHandler(RecursoNaoEncontradoException.class)
        public ResponseEntity<Map<String, String>> tratarNaoEncontrado(
                        RecursoNaoEncontradoException exception
        ) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("message", exception.getMessage()));
        }

        @ExceptionHandler(AccessDeniedException.class)
        public ResponseEntity<Map<String, String>> tratarAcessoNegado() {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                                .body(Map.of("message", "Acesso negado."));
        }

    @ExceptionHandler({
            IllegalArgumentException.class,
            IllegalStateException.class
    })
    public ResponseEntity<Map<String, String>> tratarRegraDeNegocio(
            RuntimeException exception
    ) {
        return ResponseEntity.badRequest()
                .body(Map.of("message", exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> tratarErro(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Ocorreu um erro inesperado na API."));
    }
}
