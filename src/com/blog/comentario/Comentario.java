package com.blog.comentario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.blog.usuario.Usuario;

@Entity
@Table(name = "comentario")
public class Comentario {
	@Id
	@GeneratedValue
	private Long identificador;
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	@Column
	private String conteudo;
	@Column
	private Date dataCriacao;
	@Column(name = "identificador_topico")
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

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
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
