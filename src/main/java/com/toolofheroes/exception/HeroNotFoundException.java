package com.toolofheroes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HeroNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public HeroNotFoundException(Long id) {
		super("Não existe hero com o id " + id);
	}  

}
