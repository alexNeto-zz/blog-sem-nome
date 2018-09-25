package com.locadora;

import javax.persistence.Id;

public class Identificador {

	@Id
	private Long identificador;

	public Long getId() {
		return identificador;
	}

	public void setId(Long identificador) {
		this.identificador = identificador;
	}
}
