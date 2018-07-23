package com.uniritter.instaRitterTeam.services;

import java.security.InvalidParameterException;
import java.util.Calendar;

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
@TestPropertySource("classpath:test.properties")
public class IncluirFotoTest {
	
	@Autowired
	@Qualifier("fotoServiceDatabase") 
	FotoService fotoService;
	
	@Test
	public void deveValidarFotoSemConteudo() {
		try { 
			FotoParaIncluirDto dto = new FotoParaIncluirDto("legenda", null, Calendar.getInstance());
			fotoService.incluir(dto);
			Assert.fail("N�o deveria ter inclu�do o teste");
		} catch (InvalidParameterException e) {
			Assert.assertEquals("Foto deve ter conte�do.", e.getMessage());
		}
	}
}
