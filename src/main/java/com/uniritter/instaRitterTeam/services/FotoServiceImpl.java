package com.uniritter.instaRitterTeam.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.factories.FotoFactory;
import com.uniritter.instaRitterTeam.models.Foto;
import com.uniritter.instaRitterTeam.repositories.FotoRepository;

@Component(value = "fotoServiceDatabase")
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

	@Override
	public Foto consultar(Long id) {
		return fotoRepository.findById(id).orElse(null);
	}

	@Override
	public ArrayList<Foto> listar() {
		return (ArrayList<Foto>) fotoRepository.findAll();
	}
}
