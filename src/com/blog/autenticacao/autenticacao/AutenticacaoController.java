package com.blog.autenticacao.autenticacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/autenticacao")
public class AutenticacaoController extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -4293549827107647532L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AutenticacaoService autenticacao = new AutenticacaoService();
		String apelido = autenticacao.fazAutenticacao(request);
		if (apelido != null)
			request.getSession().setAttribute("apelido", apelido);
		else
			response.setStatus(403);
	}

}
