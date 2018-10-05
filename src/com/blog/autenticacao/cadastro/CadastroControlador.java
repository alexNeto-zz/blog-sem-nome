package com.blog.autenticacao.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro")
public class CadastroControlador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5831928775369675189L;

	@Override
	protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		CadastroServico cadastro = new CadastroServico();
		if (cadastro.fazCadastro(requisicao))
			resposta.setStatus(200);
		else
			resposta.setStatus(200);
	}

}