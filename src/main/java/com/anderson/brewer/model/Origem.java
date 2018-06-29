package com.anderson.brewer.model;

public enum Origem {
	
	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	/*Atributo*/
	private String descricao;
	
	/*Construtor*/
	Origem(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}

}



