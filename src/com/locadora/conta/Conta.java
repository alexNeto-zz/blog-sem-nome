package com.locadora.conta;

import java.math.BigDecimal;
import java.util.List;

import com.locadora.automovel.Automovel;
import com.locadora.usuario.Usuario;

//@Entity
//@Table(name = "conta")
public class Conta {

//	@Id
//	@GeneratedValue
	private Long id;
//	@OneToMany(mappedBy = "conta")
	private List<Automovel> ReservaList;
//	@Column
	private List<Automovel> AbertoList;
//	@Column
	private List<Automovel> AlugadoList;
//	@Column
	private BigDecimal multa;
//	@Column
	private BigDecimal desconto;
//	@Column
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
