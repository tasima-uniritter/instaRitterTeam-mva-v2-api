package com.uniritter.instaRitterTeam.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "FOTO")
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String legenda;
	private Byte[] conteudo;
	private Calendar data;
	private String usuario;

	public Long getId() {
		return id;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean temUsuario() {
		return StringUtils.isNotBlank(usuario);
	}
}
