package br.com.cwcdev.service;

import java.time.LocalDate;

import br.com.cwcdev.entidades.Filme;
import br.com.cwcdev.entidades.Locacao;
import br.com.cwcdev.entidades.Usuario;
import br.com.cwcdev.exceptions.DadosInvalidosException;
import br.com.cwcdev.exceptions.EstoqueInsuficienteException;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {
        validarDadosLocacao(usuario, filme);
        reduzirEstoque(filme);
        return criarLocacao(usuario, filme);
    }
    
    private void validarDadosLocacao(Usuario usuario, Filme filme) {
        if (usuario == null) {
            throw new DadosInvalidosException("Usuário não pode ser nulo");
        }
        
        if (filme == null) {
            throw new DadosInvalidosException("Filme não pode ser nulo");
        }
        
        if (filme.getEstoque() <= 0) {
            throw new EstoqueInsuficienteException(
                "Estoque insuficiente para o filme: " + filme.getTitulo());
        }
        
        // Validações adicionais
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new DadosInvalidosException("Nome do usuário é obrigatório");
        }
        
        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            throw new DadosInvalidosException("Nome do filme é obrigatório");
        }
        
        if (filme.getValor() <= 0) {
            throw new DadosInvalidosException("Valor do filme deve ser positivo");
        }
    }
    
    private void reduzirEstoque(Filme filme) {
        int novoEstoque = filme.getEstoque() - 1;
        filme.setEstoque(novoEstoque);
    }
    
    private Locacao criarLocacao(Usuario usuario, Filme filme) {
        LocalDate dataLocacao = LocalDate.now();
        LocalDate dataRetorno = LocalDate.now().plusDays(1);

        return new Locacao(usuario, filme, filme.getValor(), dataLocacao, dataRetorno);
    }
}