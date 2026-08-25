package com.senai.cantina.cantina.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.senai.cantina.cantina.model.Usuario;
import com.senai.cantina.cantina.model.Usuario.TipoUsuario;
import com.senai.cantina.cantina.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void cadastrarClienteNormalizaEmailDefinePerfilEcodificaSenha() {
        Usuario usuario = usuario(" Maria@EXAMPLE.COM ", "senha");
        when(usuarioRepository.existsByEmail("maria@example.com"))
                .thenReturn(false);
        when(passwordEncoder.encode("senha")).thenReturn("senha-codificada");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.cadastrarCliente(usuario);

        assertEquals(usuario, resultado);
        assertEquals("maria@example.com", usuario.getEmail());
        assertEquals(TipoUsuario.CLIENTE, usuario.getTipoUsuario());
        assertEquals(true, usuario.isAtivo());
        assertEquals("senha-codificada", usuario.getSenha());
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void cadastrarClienteComEmailExistenteRejeitaUsuario() {
        Usuario usuario = usuario("maria@example.com", "senha");
        when(usuarioRepository.existsByEmail("maria@example.com"))
                .thenReturn(true);

        assertThrows(IllegalStateException.class,
                () -> usuarioService.cadastrarCliente(usuario));
    }

    @Test
    void cadastrarFuncionarioNaoPermitePerfilCliente() {
        Usuario usuario = usuario("maria@example.com", "senha");

        assertThrows(IllegalArgumentException.class,
                () -> usuarioService.cadastrarFuncionario(
                        usuario, TipoUsuario.CLIENTE));
    }

    @Test
    void buscarPorEmailNormalizaConsulta() {
        Usuario usuario = usuario("maria@example.com", "senha-codificada");
        when(usuarioRepository.findByEmail("maria@example.com"))
                .thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarPorEmail(" Maria@EXAMPLE.COM ");

        assertEquals(usuario, resultado);
        verify(usuarioRepository).findByEmail("maria@example.com");
    }

    @Test
    void buscarPorEmailVazioRejeitaConsulta() {
        assertThrows(IllegalArgumentException.class,
                () -> usuarioService.buscarPorEmail("  "));
    }

    private Usuario usuario(String email, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuario;
    }
}