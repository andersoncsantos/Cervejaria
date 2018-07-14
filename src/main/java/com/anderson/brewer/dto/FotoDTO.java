package com.anderson.brewer.dto;

public class FotoDTO {
	
	private String nome;
	
	private String contentType;
	
    /*Quick Access: gcuf*/
	public FotoDTO(String nome, String contentType) {
		this.nome = nome;
		this.contentType = contentType;
	}

	/*Quick Access: ggas*/ 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	
}



