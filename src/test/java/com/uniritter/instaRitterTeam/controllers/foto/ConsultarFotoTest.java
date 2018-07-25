package com.uniritter.instaRitterTeam.controllers.foto;

import static org.junit.Assert.assertNull;

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
public class ConsultarFotoTest extends BaseTeste {

	@Autowired
	FotoController fotoController;

	@Test
	public void deveConsultarFoto() {
		Byte[] conteudo = new Byte[3];
		conteudo[0] = new Byte("1");
		conteudo[1] = new Byte("2");
		conteudo[2] = new Byte("3");
		String usuario = "Pelé";
		String legenda = "legenda";
		Calendar dataAtual = Calendar.getInstance();
		FotoParaIncluirDto dto = new FotoParaIncluirDto(legenda, conteudo, usuario);
		Foto foto = fotoController.incluir(dto);

		Foto fotoIncluida = fotoController.consultar(foto.getId());

		Assert.assertEquals(fotoIncluida.getLegenda(), legenda);
		Assert.assertArrayEquals(fotoIncluida.getConteudo(), conteudo);
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotoIncluida.getData().get(Calendar.DAY_OF_YEAR));
		Assert.assertEquals(foto.getUsuario(), usuario);
	}

	@Test
	public void deveRetornarNullQuandoFotoNaoExistir() {
		assertNull(fotoController.consultar(999l));
	}
}
