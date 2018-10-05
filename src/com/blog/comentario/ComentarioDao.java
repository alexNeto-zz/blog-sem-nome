package com.blog.comentario;

import java.util.List;

import com.blog.nucleo.Dao;

public interface ComentarioDao extends Dao<Comentario> {

	public List<Comentario> encontrarPeloIdentificadorTopico(Long identificador);
	public List<Comentario> encontrarPeloApelido(String apelido);
}
