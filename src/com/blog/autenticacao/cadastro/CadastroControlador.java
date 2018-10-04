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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CadastroServico cadastro = new CadastroServico();
		if (cadastro.fazCadastro(request))
			response.setStatus(200);
		else
			response.setStatus(200);
	}

}