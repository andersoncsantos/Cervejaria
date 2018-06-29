package com.anderson.brewer.model;

public enum Sabor {
	
	ADOCICADA("Adocicada"),
	AMARGA("Amarga"),
	FORTE("Forte"),
	FRUTADA("Frutada"),
	SUAVE("Suave");
	
	/*Atributo*/
	private String descricao;
		
		/*Construtor*/
		Sabor(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao(){
			return descricao;
		}

}


