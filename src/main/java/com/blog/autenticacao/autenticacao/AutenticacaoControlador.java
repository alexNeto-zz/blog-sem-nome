package com.blog.autenticacao.autenticacao;

import java.io.IOException;
import java.io.PrintWriter;

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
		if (apelido != null) {
			requisicao.getSession().setAttribute("apelido", apelido);
			resposta.setStatus(200);
			resposta.setContentType("application/json");
			PrintWriter out = resposta.getWriter();  
			out.print("{\"status\": 200}");
			out.flush();
		}
		else
			resposta.setStatus(403);
	}

}
