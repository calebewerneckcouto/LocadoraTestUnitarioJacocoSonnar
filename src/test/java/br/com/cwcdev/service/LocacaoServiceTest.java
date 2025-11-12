package br.com.cwcdev.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cwcdev.entidades.Filme;
import br.com.cwcdev.entidades.Locacao;
import br.com.cwcdev.entidades.Usuario;
import br.com.cwcdev.exceptions.DadosInvalidosException;
import br.com.cwcdev.exceptions.EstoqueInsuficienteException;

class LocacaoServiceTest {

    private LocacaoService locacaoService;

    @BeforeEach
    void setUp() {
        locacaoService = new LocacaoService();
    }

    @Test
    void deveAlugarFilmeComSucesso() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        Locacao locacao = locacaoService.alugarFilme(usuario, filme);

        assertNotNull(locacao);
        assertEquals(usuario, locacao.getUsuario());
        assertEquals(filme, locacao.getFilme());
        assertEquals(filme.getValor(), locacao.getValor());
        assertEquals(LocalDate.now(), locacao.getDataLocacao());
        assertEquals(LocalDate.now().plusDays(1), locacao.getDataRetorno());
    }

    @Test
    void deveReduzirEstoqueAposLocacao() {
        Usuario usuario = new Usuario("Maria", "maria@email.com");
        Filme filme = new Filme("Filme Teste", 5, 10.0);
        int estoqueInicial = filme.getEstoque();

        locacaoService.alugarFilme(usuario, filme);

        assertEquals(estoqueInicial - 1, filme.getEstoque());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNulo() {
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(null, filme));
        
        assertEquals("Usuário não pode ser nulo", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoFilmeNulo() {
        Usuario usuario = new Usuario("João", "joao@email.com");

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, null));
        
        assertEquals("Filme não pode ser nulo", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoEstoqueZerado() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme("Filme Teste", 0, 10.0);

        EstoqueInsuficienteException exception = assertThrows(EstoqueInsuficienteException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Estoque insuficiente para o filme: Filme Teste", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioSemNome() {
        Usuario usuario = new Usuario("", "joao@email.com");
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Nome do usuário é obrigatório", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoFilmeSemNome() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme("", 5, 10.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Nome do filme é obrigatório", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoValorFilmeInvalido() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme("Filme Teste", 5, 0.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Valor do filme deve ser positivo", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNomeNulo() {
        Usuario usuario = new Usuario(null, "joao@email.com");
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Nome do usuário é obrigatório", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoFilmeNomeNulo() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme(null, 5, 10.0);

        DadosInvalidosException exception = assertThrows(DadosInvalidosException.class,
            () -> locacaoService.alugarFilme(usuario, filme));
        
        assertEquals("Nome do filme é obrigatório", exception.getMessage());
    }
}