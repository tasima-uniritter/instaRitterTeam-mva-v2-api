package com.uniritter.instaRitterTeam.instaRitterTeammvav2api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniritter.instaRitterTeam.services.FotoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstaRitterTeamMvaV2ApiApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	FotoServiceImpl fotoService;
	
	@Test
	public void devePassarPorqueTaVazio() {
		fotoService.incluir(null);
	}	

}
