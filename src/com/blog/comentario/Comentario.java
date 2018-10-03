package com.blog.comentario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {
	@Id
	@GeneratedValue
	private Long identificador;
	@Column
	private String apelido;
	@Column(columnDefinition = "text")
	private String conteudo;
	@Column
	private Date dataCriacao;
	@Column
	private Long identificadorTopico;

	public Long getIdentificadorTopico() {
		return identificadorTopico;
	}

	public void setIdentificadorTopico(Long identificadorTopico) {
		this.identificadorTopico = identificadorTopico;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
