package com.uniritter.instaRitterTeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.factories.FotoFactory;
import com.uniritter.instaRitterTeam.models.Foto;
import com.uniritter.instaRitterTeam.repositories.FotoRepository;

@Component(value="fotoServiceDatabase")
public class FotoServiceImpl implements FotoService {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	@Autowired
	private FotoFactory fotoFactory;
	
	@Override
	public Foto incluir(FotoParaIncluirDto fotoParaIncluirDto) {
		Foto foto = fotoFactory.fabricarFoto(fotoParaIncluirDto);
		return fotoRepository.save(foto);
	}
}
