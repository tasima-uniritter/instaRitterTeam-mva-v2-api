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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Foto")
public class FotoController {

	@Autowired
	private FotoService service;

	@ApiOperation(value = "Incluir Fotos", response = Foto.class)
	@RequestMapping(value = "/fotos", method = RequestMethod.PUT)
	public Foto incluir(@RequestBody FotoParaIncluirDto fotoParaIncluirDto) {
		return service.incluir(fotoParaIncluirDto);
	}

	@ApiOperation(value = "consultar foto", response = Foto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(value = "/fotos/{id}", method = RequestMethod.GET)
	public Foto consultar(@PathVariable("id") Long id) {
		return service.consultar(id);
	}

	@ApiOperation(value = "listar fotos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@RequestMapping(value = "/fotos", method = RequestMethod.GET)
	public List<Foto> listar() {
		return service.listar();
	}
}