package com.uniritter.instaRitterTeam.factories;

import org.springframework.stereotype.Service;

import com.uniritter.instaRitterTeam.builders.FotoBuilder;
import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

@Service
public class FotoFactory {
	public Foto fabricarFoto(FotoParaIncluirDto fotoParaIncluirDto) {
		return new FotoBuilder()
				.comConteudo(fotoParaIncluirDto.getConteudo())
				.instanciar();
	}
}
