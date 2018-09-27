package com.locadora.automovel;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.locadora.compartilhado.enumeradores.Categoria;
import com.locadora.compartilhado.enumeradores.EstadoConservacao;

//@Entity
//@Table(name = "automovel")
public class Automovel {
//
//	@Id
	private Long identificador;
//	@Column
	private Categoria categoria;
//	@Column
	private Integer ano;
//	@Column
	private String placa;
//	@Column
	private String modelo;
//	@Column
	private String fabricante;
//	@Column
	private String cor;
//	@Column
	private EstadoConservacao estadoConcervacao;
//	@Column
	private BigDecimal quilometragem;
//	@Column
	private BigDecimal tanqueCombustivel;

	@Column

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public EstadoConservacao getEstadoConcervacao() {
		return estadoConcervacao;
	}

	public void setEstadoConcervacao(EstadoConservacao estadoConcervacao) {
		this.estadoConcervacao = estadoConcervacao;
	}

	public BigDecimal getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(BigDecimal quilometragem) {
		this.quilometragem = quilometragem;
	}

	public BigDecimal getTanqueCombustivel() {
		return tanqueCombustivel;
	}

	public void setTanqueCombustivel(BigDecimal tanqueCombustivel) {
		this.tanqueCombustivel = tanqueCombustivel;
	}

}
