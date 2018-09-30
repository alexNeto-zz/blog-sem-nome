package com.locadora.autenticacao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.locadora.usuario.Usuario;
import com.locadora.usuario.UsuarioServico;

@WebServlet("/autenticacao")
public class AutenticacaoController extends HttpServlet {

	/**
	* 
	*/
	private static final long serialVersionUID = -4293549827107647532L;
	private String jspPath = "autenticacao.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(jspPath).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AutenticacaoService autenticacao = new AutenticacaoService();
		request.getSession().setAttribute("nomeUsuario", autenticacao.fazAutenticacao(request));
		request.getRequestDispatcher(jspPath).forward(request, response);
	}

}
