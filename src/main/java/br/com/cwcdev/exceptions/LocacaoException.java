package br.com.cwcdev.exceptions;

public class LocacaoException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocacaoException(String message) {
        super(message);
    }
    
    public LocacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}