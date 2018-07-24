package com.uniritter.instaRitterTeam.controllers.foto;

import java.security.InvalidParameterException;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniritter.instaRitterTeam.BaseTeste;
import com.uniritter.instaRitterTeam.controllers.FotoController;
import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IncluirFotoTest extends BaseTeste {

	@Autowired
	FotoController fotoController;

	@Test
	public void deveValidarFotoSemConteudo() {
		try {
			FotoParaIncluirDto dto = new FotoParaIncluirDto("legenda", null);
			fotoController.incluir(dto);
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
		Foto foto = fotoController.incluir(dto);
		Foto fotoIncluida = fotoController.consultar(foto.getId());
		Assert.assertEquals(fotoIncluida.getLegenda(), legenda);
		Assert.assertArrayEquals(fotoIncluida.getConteudo(), conteudo);
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotoIncluida.getData().get(Calendar.DAY_OF_YEAR));
	}
}
