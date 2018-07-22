package com.uniritter.instaRitterTeam.dtos;

import java.util.Calendar;

public class FotoParaIncluirDto {
	private String legenda;
	private Byte[] conteudo;
	private Calendar data;

	public FotoParaIncluirDto() {
	}

	public FotoParaIncluirDto(String legenda, Byte[] conteudo, Calendar data) {
		super();
		this.legenda = legenda;
		this.conteudo = conteudo;
		this.data = data;
	}

	public String getLegenda() {
		return legenda;
	}

	public Byte[] getConteudo() {
		return conteudo;
	}

	public Calendar getData() {
		return data;
	}
}
