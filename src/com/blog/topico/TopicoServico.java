package com.blog.topico;

import java.util.List;

public class TopicoServico {

	public List<Topico> pegaTodos() {
		TopicoDao  topicoRepositorio = TopicoDaoJpa.pegaInstancia();
		topicoRepositorio.encontrarTodos().forEach(item -> System.out.println(item.getTitulo()));
		return topicoRepositorio.encontrarTodos();
	}
}