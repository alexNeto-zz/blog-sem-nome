package com.blog.topico;

import com.blog.nucleo.Dao;

public interface TopicoDao extends Dao<Topico> {

	public Topico encontrarPeloIdentificador(String identificador);

}
