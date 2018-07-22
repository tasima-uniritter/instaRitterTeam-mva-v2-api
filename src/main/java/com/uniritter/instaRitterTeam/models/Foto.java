package com.uniritter.instaRitterTeam.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO")
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String legenda;
	private Byte[] conteudo;
	private Calendar data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(Byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public boolean temConteudo() {
		return conteudo != null && conteudo.length > 0;
	}
}
