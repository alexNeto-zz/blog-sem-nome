package com.locadora.reserva;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.locadora.automovel.Automovel;
import com.locadora.conta.Conta;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	private Long id;
	@Column
	private String codigoReserva;
	@Column
	private Conta conta;
	@Column
	private Date retirada;
	@Column
	private Date entregaPrevista;
	@Column
	private BigDecimal valorPrevisto;
	@Column
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
