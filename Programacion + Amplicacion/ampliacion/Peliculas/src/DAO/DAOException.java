package DAO;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException{
	
	TipoException tipoException;
	
	public DAOException(TipoException tipoException){
		super();
		this.tipoException = tipoException;
	}
	
	public TipoException getTipoException() {
		return this.tipoException;
	}
	public String getMessage() {
		return this.tipoException.getMessage();
	}
}
