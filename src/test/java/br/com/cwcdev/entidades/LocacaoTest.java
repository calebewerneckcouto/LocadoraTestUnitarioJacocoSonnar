package br.com.cwcdev.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LocacaoTest {

    @Test
    void deveCriarLocacaoCorretamente() {
        
        Usuario usuario = new Usuario("João", "joao@email.com");
        Filme filme = new Filme("Filme Teste", 5, 10.0);
        LocalDate dataLocacao = LocalDate.now();
        LocalDate dataRetorno = LocalDate.now().plusDays(1);

       
        Locacao locacao = new Locacao(usuario, filme, 10.0, dataLocacao, dataRetorno);

      
        assertEquals(usuario, locacao.getUsuario());
        assertEquals(filme, locacao.getFilme());
        assertEquals(10.0, locacao.getValor());
        assertEquals(dataLocacao, locacao.getDataLocacao());
        assertEquals(dataRetorno, locacao.getDataRetorno());
    }
}