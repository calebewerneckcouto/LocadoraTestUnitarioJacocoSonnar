package br.com.cwcdev.entidades;

public class Filme {

    private String titulo;
    private Integer estoque;
    private Double valor;
    
    
    public Filme() {
	
	}


	public Filme(String titulo, Integer estoque, Double valor) {
		super();
		this.titulo = titulo;
		this.estoque = estoque;
		this.valor = valor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Integer getEstoque() {
		return estoque;
	}


	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", estoque=" + estoque + ", valor=" + valor + "]";
	}

    
    

}
