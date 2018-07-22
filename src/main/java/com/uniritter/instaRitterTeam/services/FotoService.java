package com.uniritter.instaRitterTeam.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;
import com.uniritter.instaRitterTeam.repositories.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	public String a() {
		return "a";
	}
	
	
	
	public void incluir(FotoParaIncluirDto fotoParaIncluirDto) {
		Foto foto = new Foto("teste", new Byte[1], Calendar.getInstance());
		fotoRepository.save(foto);
	}
}
