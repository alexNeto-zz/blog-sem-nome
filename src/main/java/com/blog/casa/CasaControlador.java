package com.blog.casa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.nucleo.TipoUsuario;
import com.blog.topico.TopicoServico;
import com.blog.usuario.Usuario;
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

		requisicao.setAttribute("topicos", Lists.reverse(new TopicoServico().pegaTodos()));

		String apelido = getApelido(requisicao);
		requisicao.setAttribute("estaLogado", apelido);
		if (apelido != null)
			requisicao.setAttribute("tipoUsuario", getTipoUsuario(apelido));

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(requisicao, resposta);
	}

	private TipoUsuario getTipoUsuario(String apelido) {
		Usuario usuario = UsuarioDaoJpa.pegaInstancia().encontrarPeloNome(apelido);
		if (usuario != null)
			return usuario.getTipoUsuario();
		else 
			return TipoUsuario.NORMAL;
	}

	private String getApelido(HttpServletRequest requisicao) {
		if (requisicao.getSession() != null)
			return (String) requisicao.getSession().getAttribute("apelido");
		else
			return null;
	}
}
