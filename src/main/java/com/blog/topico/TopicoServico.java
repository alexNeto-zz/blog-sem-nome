package com.blog.topico;

import java.util.List;

import org.json.JSONObject;

import com.blog.comentario.ComentarioDao;
import com.blog.comentario.ComentarioDaoJpa;

public class TopicoServico {

	private TopicoDao topicoRepositorio = TopicoDaoJpa.pegaInstancia();
	private ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();

	public List<Topico> pegaTodos() {
		return topicoRepositorio.encontrarTodos();
	}

	public JSONObject pegaPeloIdentificador(Object object) {
		Topico topico = topicoRepositorio.encontrarPeloIdentificador(Long.valueOf((String) object));
		topico.setComentarios(comentarioRepositorio.encontrarPeloIdentificadorTopico(topico.getIdentificador()));
		return new JSONObject(topico);

	}
}