package model.exceptions;

public class DomainException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//entidade de dominio que pode dar algum erro, por isso o nome da classe + exception pq é classe de exceção
	//se for runtime exception ele deixa o programa executar, se não você é obrigado a tratar a exceção

	public DomainException(String msg) {
		super(msg);
	}
}
