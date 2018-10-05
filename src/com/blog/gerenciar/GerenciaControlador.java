package com.blog.gerenciar;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.usuario.Usuario;
import com.blog.usuario.UsuarioServico;
import com.google.common.collect.Lists;

@WebServlet("/restrito/gerenciar")
public class GerenciaControlador extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792656053291940932L;

	@Override
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		UsuarioServico usuarioServico = new UsuarioServico();
		List<Usuario> usuarios = Lists.reverse(usuarioServico.pegaTodos());

		requisicao.setAttribute("usuarios", usuarios);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/gerencia.jsp");
		rd.forward(requisicao, resposta);
	}
}
