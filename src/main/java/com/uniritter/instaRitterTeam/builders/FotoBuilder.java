package com.uniritter.instaRitterTeam.builders;

import java.security.InvalidParameterException;
import java.util.Calendar;

import com.uniritter.instaRitterTeam.models.Foto;

public class FotoBuilder {
	private Foto foto;
	
	public FotoBuilder() {
		foto = new Foto();
	}
	
	public FotoBuilder comLegenda(String legenda) {
		foto.setLegenda(legenda);
		return this;
	}
	
	public FotoBuilder comData(Calendar data) {
		foto.setData(data);
		return this;
	}
	
	public FotoBuilder comConteudo(Byte[] conteudo) {
		foto.setConteudo(conteudo);
		return this;
	}
	
	public Foto instanciar() {
		validarConteudo();
		return foto;
	}

	private void validarConteudo() {
		if(!foto.temConteudo()) {
			throw new InvalidParameterException("Foto deve ter conteúdo.");
		}
	}
}
