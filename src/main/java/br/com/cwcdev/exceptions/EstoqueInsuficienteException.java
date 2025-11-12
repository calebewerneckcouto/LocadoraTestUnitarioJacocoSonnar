package br.com.cwcdev.exceptions;

public class EstoqueInsuficienteException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstoqueInsuficienteException(String message) {
        super(message);
    }
    
    public EstoqueInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}