package com.blog.topico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/topico")
public class TopicoController extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -112315248180092748L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter resposta = response.getWriter();
		resposta.print(new TopicoServico().pegaPeloIdentificador(request.getParameter("topico")));
		resposta.flush();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
