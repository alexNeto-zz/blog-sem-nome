package com.blog.casa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.topico.Topico;
import com.blog.topico.TopicoServico;
import com.google.common.collect.Lists;

@WebServlet("/inicio")
public class CasaControlador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2421920873100002415L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TopicoServico topicoServico = new TopicoServico();
		List<Topico> topicos = Lists.reverse(topicoServico.pegaTodos());

		request.setAttribute("topicos", topicos);

		String apelido = request.getSession() != null ? (String) request.getSession().getAttribute("apelido") : null;
		request.setAttribute("estaLogado", apelido);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
