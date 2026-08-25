package com.senai.cantina.cantina.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.senai.cantina.cantina.exception.RecursoNaoEncontradoException;
import com.senai.cantina.cantina.model.Produto;
import com.senai.cantina.cantina.model.Produto.CategoriaProduto;
import com.senai.cantina.cantina.repository.ProdutoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void cadastrarNormalizaDadosEAtivaProduto() {
        Produto produto = new Produto();
        produto.setId(7L);
        produto.setNome("  Suco  ");
        produto.setEstoqueAtual(12);

        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto resultado = produtoService.cadastrar(produto);

        assertEquals(produto, resultado);
        assertEquals(null, produto.getId());
        assertEquals("Suco", produto.getNome());
        assertEquals(0, produto.getEstoqueAtual());
        assertEquals(true, produto.isAtivo());
        verify(produtoRepository).save(produto);
    }

    @Test
    void filtrarComCategoriaENomeUsaConsultaComNomeNormalizado() {
        CategoriaProduto categoria = CategoriaProduto.BEBIDA;
        List<Produto> esperados = List.of(new Produto());
        when(produtoRepository
                .findByCategoriaAndNomeContainingIgnoreCaseAndAtivoTrue(
                        categoria, "suco"))
                .thenReturn(esperados);

        List<Produto> resultado = produtoService.filtrar(categoria, " suco ");

        assertEquals(esperados, resultado);
        verify(produtoRepository)
                .findByCategoriaAndNomeContainingIgnoreCaseAndAtivoTrue(
                        categoria, "suco");
    }

    @Test
    void buscarPorIdInexistenteLancaRecursoNaoEncontrado() {
        when(produtoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RecursoNaoEncontradoException.class,
                () -> produtoService.buscarPorId(99L));
    }

    @Test
    void atualizarCopiaCamposEConservaProdutoPersistido() {
        Produto existente = new Produto();
        existente.setId(4L);
        Produto dadosNovos = new Produto();
        dadosNovos.setNome("  Novo nome ");
        dadosNovos.setDescricao("Descricao");
        dadosNovos.setCategoria(CategoriaProduto.LANCHE);
        dadosNovos.setPrecoCusto(new BigDecimal("2.00"));
        dadosNovos.setPrecoVenda(new BigDecimal("5.00"));
        dadosNovos.setEstoqueMinimo(3);
        dadosNovos.setPerecivel(true);

        when(produtoRepository.findById(4L)).thenReturn(Optional.of(existente));
        when(produtoRepository.save(existente)).thenReturn(existente);

        Produto resultado = produtoService.atualizar(4L, dadosNovos);

        assertEquals(existente, resultado);
        assertEquals("Novo nome", existente.getNome());
        assertEquals(dadosNovos.getDescricao(), existente.getDescricao());
        assertEquals(dadosNovos.getCategoria(), existente.getCategoria());
        assertEquals(dadosNovos.getPrecoVenda(), existente.getPrecoVenda());
        assertEquals(dadosNovos.getEstoqueMinimo(), existente.getEstoqueMinimo());
        assertEquals(dadosNovos.isPerecivel(), existente.isPerecivel());
        verify(produtoRepository).save(existente);
    }
}