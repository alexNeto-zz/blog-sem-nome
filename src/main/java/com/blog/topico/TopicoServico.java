package com.blog.topico;

import java.util.List;

import com.blog.comentario.ComentarioDao;
import com.blog.comentario.ComentarioDaoJpa;

public class TopicoServico {

	private TopicoDao topicoRepositorio = TopicoDaoJpa.pegaInstancia();
	private ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();

	public List<Topico> pegaTodos() {
		return topicoRepositorio.encontrarTodos();
	}

	public Topico pegaPeloIdentificador(Object object) {

		Topico topico = topicoRepositorio.encontrarPeloIdentificador(object.toString());
		topico.setComentarios(comentarioRepositorio
				.encontrarPeloIdentificadorTopico(topico.getIdentificador() != null ? topico.getIdentificador() : 0));
		return topico;

	}
}