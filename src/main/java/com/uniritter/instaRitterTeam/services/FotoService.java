package com.uniritter.instaRitterTeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.factories.FotoFactory;
import com.uniritter.instaRitterTeam.models.Foto;
import com.uniritter.instaRitterTeam.repositories.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	@Autowired
	private FotoFactory fotoFactory;
	
	public String a() {
		return "a";
	}
	
	
	
	public void incluir(FotoParaIncluirDto fotoParaIncluirDto) {
		Foto foto = fotoFactory.fabricarFoto(fotoParaIncluirDto);
		fotoRepository.save(foto);
	}
}
