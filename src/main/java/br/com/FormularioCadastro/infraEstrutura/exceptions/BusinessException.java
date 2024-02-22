package br.com.FormularioCadastro.infraEstrutura.exceptions;

public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}
}
