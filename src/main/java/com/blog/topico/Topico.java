package com.blog.topico;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.blog.comentario.Comentario;

@Entity
@Table(name = "topico")
public class Topico {

	@Id
	@GeneratedValue
	private Long identificador;
	@Column
	private String titulo;
	@Column(columnDefinition = "text")
	private String conteudo;
	@Column
	private String dataCriacao;
	@Transient
	private List<Comentario> comentarios;

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getConteudoTamanho200() {
		return conteudo.substring(0, getConteudo().length() > 200 ? 200 : getConteudo().length());
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
