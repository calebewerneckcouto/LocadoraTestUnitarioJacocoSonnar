package br.com.cwcdev.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FilmeTest {

    @Test
    void deveCriarFilmeCorretamente() {
        
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        
        assertEquals("Filme Teste", filme.getTitulo());
        assertEquals(5, filme.getEstoque());
        assertEquals(10.0, filme.getValor());
    }

    @Test
    void devePermitirAlteracaoDeEstoque() {
       
        Filme filme = new Filme("Filme Teste", 5, 10.0);

        
        filme.setEstoque(3);

       
        assertEquals(3, filme.getEstoque());
    }
}