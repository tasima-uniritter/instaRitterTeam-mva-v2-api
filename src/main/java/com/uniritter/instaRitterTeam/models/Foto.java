package com.uniritter.instaRitterTeam.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String legenda;
	private Byte[] imagem;
	private Calendar data;

	public Foto(String legenda, Byte[] imagem, Calendar data) {
		super();
		this.legenda = legenda;
		this.imagem = imagem;
		this.data = data;
	}

}