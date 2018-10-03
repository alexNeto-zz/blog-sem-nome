package com.blog.topico;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@OneToMany
    @JoinColumn(name = "identificador_topico")
    private List<Comentario> eventos;

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
		return conteudo.substring(0, 200);
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
