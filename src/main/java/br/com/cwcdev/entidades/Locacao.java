package br.com.cwcdev.entidades;

import java.time.LocalDate;

public class Locacao {

    private Usuario usuario;
    private Filme filme;
    private Double valor;
    private LocalDate dataLocacao;
    private LocalDate dataRetorno;

    
    public Locacao() {
	
	}


	public Locacao(Usuario usuario, Filme filme, Double valor, LocalDate dataLocacao, LocalDate dataRetorno) {
		super();
		this.usuario = usuario;
		this.filme = filme;
		this.valor = valor;
		this.dataLocacao = dataLocacao;
		this.dataRetorno = dataRetorno;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public LocalDate getDataLocacao() {
		return dataLocacao;
	}


	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}


	public LocalDate getDataRetorno() {
		return dataRetorno;
	}


	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}


	@Override
	public String toString() {
		return "Locacao [usuario=" + usuario + ", filme=" + filme + ", valor=" + valor + ", dataLocacao=" + dataLocacao
				+ ", dataRetorno=" + dataRetorno + "]";
	}

    
    

}
