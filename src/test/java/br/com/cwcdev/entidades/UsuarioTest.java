package br.com.cwcdev.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UsuarioTest {

    @Test
    void deveCriarUsuarioCorretamente() {
       
        Usuario usuario = new Usuario("João", "joao@email.com");

      
        assertEquals("João", usuario.getNome());
        assertEquals("joao@email.com", usuario.getEmail());
    }

    @Test
    void devePermitirAlteracaoDeDados() {
        
        Usuario usuario = new Usuario("João", "joao@email.com");

        
        usuario.setNome("Maria");
        usuario.setEmail("maria@email.com");

        
        assertEquals("Maria", usuario.getNome());
        assertEquals("maria@email.com", usuario.getEmail());
    }
}