package com.blog.comentario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.utilitario.RespostaPadrao;

@WebServlet("/comentario")
public class ComentarioControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -112315248180092748L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		ComentarioServico comentario = new ComentarioServico();
		if (comentario.salvaComentario(requisicao))
			resposta.setStatus(200);
		else
			resposta.setStatus(200);
		resposta.setContentType("application/json");
		RespostaPadrao.json(resposta.getWriter());
	}

	@Override
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		ComentarioServico comentario = new ComentarioServico();
		comentario.apagaComentario(requisicao.getParameter("identificador"));
		resposta.setStatus(200);
	}

}
