package com.blog.topico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/topico")
public class TopicoControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -112315248180092748L;

	@Override
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		resposta.setContentType("application/json");
		PrintWriter respostaEscritor = resposta.getWriter();
		respostaEscritor.print(new TopicoServico().pegaPeloIdentificador(requisicao.getParameter("topico")));
		respostaEscritor.flush();
	}
}
