package com.uniritter.instaRitterTeam.services;

import static org.junit.Assert.assertNull;

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

import com.uniritter.instaRitterTeam.BaseTeste;
import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

public class ConsultarFotoTest extends BaseTeste {

	@Autowired
	FotoService fotoService;

	@Test
	public void deveConsultarFoto() {
		Byte[] conteudo = new Byte[3];
		conteudo[0] = new Byte("1");
		conteudo[1] = new Byte("2");
		conteudo[2] = new Byte("3");
		String legenda = "legenda";
		Calendar dataAtual = Calendar.getInstance();
		FotoParaIncluirDto dto = new FotoParaIncluirDto(legenda, conteudo);
		Foto foto = fotoService.incluir(dto);

		Foto fotoIncluida = fotoService.consultar(foto.getId());

		Assert.assertEquals(fotoIncluida.getLegenda(), legenda);
		Assert.assertArrayEquals(fotoIncluida.getConteudo(), conteudo);
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotoIncluida.getData().get(Calendar.DAY_OF_YEAR));
	}

	@Test
	public void deveRetornarNullQuandoFotoNaoExistir() {
		assertNull(fotoService.consultar(999l));
	}
}
