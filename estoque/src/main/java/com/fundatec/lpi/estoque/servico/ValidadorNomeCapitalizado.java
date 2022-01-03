package com.fundatec.lpi.estoque.servico;

public class ValidadorNomeCapitalizado implements ValidadorNome {
	
	public String valida(String nome) {
		
		return nome.substring( 0, 1 ).toUpperCase() + nome.substring( 1 );
	}

	
}
