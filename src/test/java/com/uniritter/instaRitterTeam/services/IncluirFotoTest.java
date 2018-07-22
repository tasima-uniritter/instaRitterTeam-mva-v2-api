package com.uniritter.instaRitterTeam.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IncluirFotoTest {
	
	@Autowired
	FotoService fotoService;
	
	@Test
	public void devePassarPorqueTaVazio() {
		fotoService.incluir(null);
	}

}
