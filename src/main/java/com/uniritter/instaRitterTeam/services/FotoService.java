package com.uniritter.instaRitterTeam.services;

import java.util.ArrayList;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

public interface FotoService {
	public Foto incluir(FotoParaIncluirDto fotoParaIncluirDto);
	
	public Foto consultar(Long id);
	
	public ArrayList<Foto> listar();
}
