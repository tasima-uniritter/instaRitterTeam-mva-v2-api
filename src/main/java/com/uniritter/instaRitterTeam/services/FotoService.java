package com.uniritter.instaRitterTeam.services;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

public interface FotoService {
	public Foto incluir(FotoParaIncluirDto fotoParaIncluirDto);
}
