package com.blog.autenticacao.autenticacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/autenticacao")
public class AutenticacaoControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -4293549827107647532L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		AutenticacaoServico autenticacao = new AutenticacaoServico();
		String apelido = autenticacao.fazAutenticacao(requisicao);
		if (apelido != null)
			requisicao.getSession().setAttribute("apelido", apelido);
		else
			resposta.setStatus(403);
	}

}
