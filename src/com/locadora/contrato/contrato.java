package com.locadora.contrato;

import java.math.BigDecimal;
import java.util.Date;

import com.locadora.automovel.Automovel;
import com.locadora.conta.Conta;

public class contrato {

	private Conta conta;
	private Automovel automovel;
	private Date retiradaEfetiva;
	private Date entregaEfetiva;
	private BigDecimal totalEfetivo;
	private BigDecimal pagoRetirada;
	private BigDecimal pagoDevolucao;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Date getRetiradaEfetiva() {
		return retiradaEfetiva;
	}

	public void setRetiradaEfetiva(Date retiradaEfetiva) {
		this.retiradaEfetiva = retiradaEfetiva;
	}

	public Date getEntregaEfetiva() {
		return entregaEfetiva;
	}

	public void setEntregaEfetiva(Date entregaEfetiva) {
		this.entregaEfetiva = entregaEfetiva;
	}

	public BigDecimal getTotalEfetivo() {
		return totalEfetivo;
	}

	public void setTotalEfetivo(BigDecimal totalEfetivo) {
		this.totalEfetivo = totalEfetivo;
	}

	public BigDecimal getPagoRetirada() {
		return pagoRetirada;
	}

	public void setPagoRetirada(BigDecimal pagoRetirada) {
		this.pagoRetirada = pagoRetirada;
	}

	public BigDecimal getPagoDevolucao() {
		return pagoDevolucao;
	}

	public void setPagoDevolucao(BigDecimal pagoDevolucao) {
		this.pagoDevolucao = pagoDevolucao;
	}
	
}
