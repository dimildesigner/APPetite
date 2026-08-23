package com.senai.cantina.cantina.dto;

import com.senai.cantina.cantina.model.Usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        Usuario.TipoUsuario tipoUsuario,
        boolean ativo
) {
    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTipoUsuario(),
                usuario.isAtivo()
        );
    }
}
