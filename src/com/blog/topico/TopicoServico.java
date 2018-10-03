package com.blog.topico;

import java.util.List;

import org.json.JSONObject;

public class TopicoServico {

	private TopicoDao  topicoRepositorio = TopicoDaoJpa.pegaInstancia();
	
	public List<Topico> pegaTodos() {
		return topicoRepositorio.encontrarTodos();
	}
	
	public JSONObject pegaPeloIdentificador(Object object) {
		Topico topico = topicoRepositorio.encontrarPeloIdentificador(Long.valueOf((String) object));
		return new JSONObject(topico);
		
	}
}