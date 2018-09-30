package com.locadora.autenticacao;

import javax.servlet.http.HttpServletRequest;

import com.locadora.usuario.UsuarioServico;

public class AutenticacaoService {

	protected String fazAutenticacao(HttpServletRequest request) {
		String usuario = request.getParameter("nomeUsuario");
		String senha = request.getParameter("senha");
		UsuarioServico usuarioServico = new UsuarioServico();
		return usuarioServico.encontrar(usuario, senha);
	}
}
