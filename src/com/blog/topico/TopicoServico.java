package com.blog.topico;

import java.util.List;

public class TopicoServico {

	public List<Topico> pegaTodos() {
		TopicoDao  topicoRepositorio = TopicoDaoJpa.pegaInstancia();
		return topicoRepositorio.encontrarTodos();
	}
}