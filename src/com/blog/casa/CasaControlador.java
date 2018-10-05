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
import com.blog.usuario.UsuarioDaoJpa;
import com.google.common.collect.Lists;

@WebServlet("/inicio")
public class CasaControlador extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2421920873100002415L;

	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {

		TopicoServico topicoServico = new TopicoServico();
		List<Topico> topicos = Lists.reverse(topicoServico.pegaTodos());

		requisicao.setAttribute("topicos", topicos);

		String apelido = requisicao.getSession() != null ? (String) requisicao.getSession().getAttribute("apelido") : null;
		requisicao.setAttribute("estaLogado", apelido);
		if(apelido != null) {
			requisicao.setAttribute("tipoUsuario", UsuarioDaoJpa.pegaInstancia().encontrarPeloNome(apelido).getTipoUsuario());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(requisicao, resposta);
	}

}
