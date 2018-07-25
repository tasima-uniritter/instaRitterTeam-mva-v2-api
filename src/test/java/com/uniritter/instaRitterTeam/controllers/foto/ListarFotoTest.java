package com.uniritter.instaRitterTeam.controllers.foto;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

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
public class ListarFotoTest extends BaseTeste {

	@Autowired
	FotoController fotoController;

	@Test
	public void deveListarFotos() {
		Byte[] conteudo = new Byte[3];
		conteudo[0] = new Byte("1");
		conteudo[1] = new Byte("2");
		conteudo[2] = new Byte("3");
		String legenda = "legenda";
		Calendar dataAtual = Calendar.getInstance();
		String usuario = "Tostão";
		FotoParaIncluirDto dto = new FotoParaIncluirDto(legenda, conteudo, usuario);
		Foto foto1 = fotoController.incluir(dto);

		Byte[] conteudo2 = new Byte[3];
		conteudo2[0] = new Byte("4");
		conteudo2[1] = new Byte("6");
		conteudo2[2] = new Byte("1");
		String legenda2 = "legenda2";
		String usuario2 = "Didi";
		
		FotoParaIncluirDto dto2 = new FotoParaIncluirDto(legenda2, conteudo2, usuario2);
		Foto foto2 = fotoController.incluir(dto2);

		List<Foto> fotos = fotoController.listar();

		Foto primeiraFoto = fotos.get(0);
		Assert.assertEquals(primeiraFoto.getId(), foto1.getId());
		Assert.assertEquals(primeiraFoto.getLegenda(), foto1.getLegenda());
		Assert.assertArrayEquals(primeiraFoto.getConteudo(), foto1.getConteudo());
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), primeiraFoto.getData().get(Calendar.DAY_OF_YEAR));
		Assert.assertEquals(usuario, primeiraFoto.getUsuario());

		Foto segundaFoto = fotos.get(1);
		Assert.assertEquals(segundaFoto.getId(), foto2.getId());
		Assert.assertEquals(segundaFoto.getLegenda(), foto2.getLegenda());
		Assert.assertArrayEquals(segundaFoto.getConteudo(), foto2.getConteudo());
		Assert.assertEquals(dataAtual.get(Calendar.DAY_OF_YEAR), segundaFoto.getData().get(Calendar.DAY_OF_YEAR));
		Assert.assertEquals(segundaFoto.getUsuario(), usuario2);
	}

	@Test
	public void deveRetornarUmaListaVaziaQuandoNaoExistirFotosCadastradas() {
		assertTrue(fotoController.listar().isEmpty());
	}
}
