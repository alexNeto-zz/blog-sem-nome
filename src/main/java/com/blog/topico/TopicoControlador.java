package com.blog.topico;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.usuario.UsuarioDaoJpa;

@WebServlet("/topico")
public class TopicoControlador extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -112315248180092748L;

	@Override
	protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {

		Topico topico = new TopicoServico().pegaPeloIdentificador(requisicao.getParameter("topico"));

		requisicao.setAttribute("topico", topico);
		
		String apelido = requisicao.getSession() != null ? (String) requisicao.getSession().getAttribute("apelido")
				: null;
		requisicao.setAttribute("estaLogado", apelido);
		if (apelido != null) {
			requisicao.setAttribute("tipoUsuario",
					UsuarioDaoJpa.pegaInstancia().encontrarPeloNome(apelido).getTipoUsuario());
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/topico.jsp");
		rd.forward(requisicao, resposta);

		// resposta.setContentType("application/json");
		// PrintWriter respostaEscritor = resposta.getWriter();
		// respostaEscritor.print(new
		// TopicoServico().pegaPeloIdentificador(requisicao.getParameter("topico")));
		// respostaEscritor.flush();
	}
}
