package com.locadora.reserva;

import java.math.BigDecimal;
import java.util.Date;

import com.locadora.automovel.Automovel;
import com.locadora.conta.Conta;

public class Reserva {
	private String codigoReserva;
	private Conta conta;
	private Date retirada;
	private Date entregaPrevista;
	private BigDecimal valorPrevisto;
	private Automovel carroReservado;

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getEntregaPrevista() {
		return entregaPrevista;
	}

	public void setEntregaPrevista(Date entregaPrevista) {
		this.entregaPrevista = entregaPrevista;
	}

	public BigDecimal getValorPrevisto() {
		return valorPrevisto;
	}

	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public Automovel getCarroReservado() {
		return carroReservado;
	}

	public void setCarroReservado(Automovel carroReservado) {
		this.carroReservado = carroReservado;
	}

}
