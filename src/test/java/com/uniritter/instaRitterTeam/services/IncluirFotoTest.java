package com.uniritter.instaRitterTeam.services;

import java.security.InvalidParameterException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

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
			FotoParaIncluirDto dto = new FotoParaIncluirDto("legenda", null);
			fotoService.incluir(dto);
			Assert.fail("Não deveria ter incluído");
		} catch (InvalidParameterException e) {
			Assert.assertEquals("Foto deve ter conteúdo.", e.getMessage());
		}
	}

	@Test
	public void deveIncluirFoto() {
		Byte[] conteudo = new Byte[1];
		conteudo[0] = new Byte("1");
		String legenda = "legenda";
		Calendar dataAtual = Calendar.getInstance();
		FotoParaIncluirDto dto = new FotoParaIncluirDto(legenda, conteudo);
		Foto foto = fotoService.incluir(dto);
		Foto fotoIncluida = fotoService.consultar(foto.getId());
		Assert.assertEquals(fotoIncluida.getLegenda(), legenda);
		Assert.assertEquals(fotoIncluida.getConteudo()[0], conteudo[0]);
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotoIncluida.getData().get(Calendar.DAY_OF_YEAR));
	}
}
