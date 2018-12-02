package com.blog.gerenciar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.comentario.ComentarioDaoJpa;
import com.blog.utilitario.RespostaPadrao;

@WebServlet("/restrito/gerenciar/comentario/apagar")
public class ApagarComentarioControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = 9052001118041172098L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		Long identificador = Long.valueOf(requisicao.getParameter("identificador"));
		ComentarioDaoJpa.pegaInstancia().apagaPeloIdentificador(identificador);
		resposta.setContentType("application/json");
		resposta.setStatus(200);
		RespostaPadrao.json(resposta.getWriter());

	}
}
