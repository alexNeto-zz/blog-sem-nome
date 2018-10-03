package com.blog.nucleo;

public enum TipoUsuario {

	ADM("Administrador"), NORMAL("usuario comum");

	private String descricao;

	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}