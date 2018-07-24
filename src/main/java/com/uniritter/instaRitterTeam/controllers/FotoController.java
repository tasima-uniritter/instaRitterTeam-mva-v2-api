package com.uniritter.instaRitterTeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;
import com.uniritter.instaRitterTeam.services.FotoService;

@RestController
public class FotoController {

	@Autowired
	private FotoService service;

	@RequestMapping(value = "/foto", method = RequestMethod.POST)
	public Foto incluir(@RequestBody FotoParaIncluirDto fotoParaIncluirDto) {
		return service.incluir(fotoParaIncluirDto);
	}

	@RequestMapping(value = "/foto/{id}", method = RequestMethod.GET)
	public Foto consultar(@PathVariable("id") Long id) {
		return service.consultar(id);
	}

	@RequestMapping(value = "/fotos", method = RequestMethod.GET)
	public List<Foto> listar() {
		return service.listar();
	}
}