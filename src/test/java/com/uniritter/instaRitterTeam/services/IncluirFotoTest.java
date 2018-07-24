package com.uniritter.instaRitterTeam.services;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IncluirFotoTest {
	
	@Autowired
	@Qualifier("fotoServiceDatabase") 
	FotoService fotoService;
	
	@Test
	public void deveValidarFotoSemConteudo() {
		try { 
			FotoParaIncluirDto dto = new FotoParaIncluirDto("legenda", null);
			fotoService.incluir(dto);
			Assert.fail("Não deveria ter incluído o teste");
		} catch (InvalidParameterException e) {
			Assert.assertEquals("Foto deve ter conteúdo.", e.getMessage());
		}
	}
}
