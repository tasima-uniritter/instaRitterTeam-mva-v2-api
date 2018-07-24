package com.uniritter.instaRitterTeam.services;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.uniritter.instaRitterTeam.BaseTeste;
import com.uniritter.instaRitterTeam.dtos.FotoParaIncluirDto;
import com.uniritter.instaRitterTeam.models.Foto;

public class ListarFotoTest extends BaseTeste {

	@Autowired
	@Qualifier("fotoServiceDatabase")
	FotoService fotoService;

	@Test
	public void deveListarFotos() {
		Byte[] conteudo = new Byte[3];
		conteudo[0] = new Byte("1");
		conteudo[1] = new Byte("2");
		conteudo[2] = new Byte("3");
		String legenda = "legenda";
		Calendar dataAtual = Calendar.getInstance();
		FotoParaIncluirDto dto = new FotoParaIncluirDto(legenda, conteudo);
		Foto foto1 = fotoService.incluir(dto);

		Byte[] conteudo2 = new Byte[3];
		conteudo2[0] = new Byte("4");
		conteudo2[1] = new Byte("6");
		conteudo2[2] = new Byte("1");
		String legenda2 = "legenda2";
		Calendar dataAtual2 = Calendar.getInstance();
		FotoParaIncluirDto dto2 = new FotoParaIncluirDto(legenda2, conteudo2);
		Foto foto2 = fotoService.incluir(dto2);

		List<Foto> fotos = fotoService.listar();

		Assert.assertEquals(fotos.get(0).getId(), foto1.getId());
		Assert.assertEquals(fotos.get(0).getLegenda(), foto1.getLegenda());
		Assert.assertArrayEquals(fotos.get(0).getConteudo(), foto1.getConteudo());
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotos.get(0).getData().get(Calendar.DAY_OF_YEAR));

		Assert.assertEquals(fotos.get(1).getId(), foto2.getId());
		Assert.assertEquals(fotos.get(1).getLegenda(), foto2.getLegenda());
		Assert.assertArrayEquals(fotos.get(1).getConteudo(), foto2.getConteudo());
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), fotos.get(1).getData().get(Calendar.DAY_OF_YEAR));
	}

	@Test
	public void deveRetornarUmaListaVaziaQuandoNaoExistirFotosCadastradas() {
		assertTrue(fotoService.listar().isEmpty());
	}
}
