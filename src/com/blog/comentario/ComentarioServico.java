package com.blog.comentario;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ComentarioServico {

	protected Boolean salvaComentario(HttpServletRequest request) {
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		Comentario comentario = new Comentario();
		comentario.setApelido((String) request.getSession().getAttribute("apelido"));
		comentario.setDataCriacao(new Date().toString());
		comentario.setIdentificadorTopico(Long.valueOf(request.getParameter("identificadorTopico")));
		comentario.setConteudo(request.getParameter("conteudo"));
		comentarioRepositorio.inserir(comentario);
		return true;
	}

	protected void apagaComentario(String identificador) {
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		comentarioRepositorio.apagaPeloIdentificador(Long.valueOf(identificador));
	}

}
