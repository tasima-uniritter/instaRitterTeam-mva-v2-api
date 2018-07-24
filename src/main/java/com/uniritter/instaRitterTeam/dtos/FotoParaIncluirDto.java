package com.uniritter.instaRitterTeam.dtos;

public class FotoParaIncluirDto {
	private String legenda;
	private Byte[] conteudo;

	public FotoParaIncluirDto() {
	}

	public FotoParaIncluirDto(String legenda, Byte[] conteudo) {
		super();
		this.legenda = legenda;
		this.conteudo = conteudo;
	}

	public String getLegenda() {
		return legenda;
	}

	public Byte[] getConteudo() {
		return conteudo;
	}
}
