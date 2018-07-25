package com.uniritter.instaRitterTeam.dtos;

public class FotoParaIncluirDto {
	private String legenda;
	private Byte[] conteudo;
	private String usuario;

	public FotoParaIncluirDto() {
	}

	

	public FotoParaIncluirDto(String legenda, Byte[] conteudo, String usuario) {
		super();
		this.legenda = legenda;
		this.conteudo = conteudo;
		this.usuario = usuario;
	}

	public String getLegenda() {
		return legenda;
	}

	public Byte[] getConteudo() {
		return conteudo;
	}

	public String getUsuario() {
		return usuario;
	}
}
