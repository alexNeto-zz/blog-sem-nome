package com.locadora.conta;

import java.math.BigDecimal;
import java.util.List;

import com.locadora.automovel.Automovel;
import com.locadora.usuario.Usuario;

public class Conta {

	private Long id;
	private List<Automovel> ReservaList;
	private List<Automovel> AbertoList;
	private List<Automovel> AlugadoList;
	private BigDecimal multa;
	private BigDecimal desconto;
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Automovel> getReservaList() {
		return ReservaList;
	}

	public void setReservaList(List<Automovel> reservaList) {
		ReservaList = reservaList;
	}

	public List<Automovel> getAbertoList() {
		return AbertoList;
	}

	public void setAbertoList(List<Automovel> abertoList) {
		AbertoList = abertoList;
	}

	public List<Automovel> getAlugadoList() {
		return AlugadoList;
	}

	public void setAlugadoList(List<Automovel> alugadoList) {
		AlugadoList = alugadoList;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
