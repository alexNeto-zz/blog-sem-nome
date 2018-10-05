package com.blog.comentario;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ComentarioServico {

	protected Boolean salvaComentario(HttpServletRequest requisicao) {
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		Comentario comentario = new Comentario();
		comentario.setApelido((String) requisicao.getSession().getAttribute("apelido"));
		comentario.setDataCriacao(new Date().toString());
		comentario.setIdentificadorTopico(Long.valueOf(requisicao.getParameter("identificadorTopico")));
		comentario.setConteudo(requisicao.getParameter("conteudo"));
		comentarioRepositorio.inserir(comentario);
		return true;
	}

	protected void apagaComentario(String identificador) {
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		comentarioRepositorio.apagaPeloIdentificador(Long.valueOf(identificador));
	}

}
