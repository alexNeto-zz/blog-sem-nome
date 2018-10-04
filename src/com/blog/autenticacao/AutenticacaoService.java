package com.blog.autenticacao;

import javax.servlet.http.HttpServletRequest;

import com.blog.usuario.UsuarioServico;

public class AutenticacaoService {

	protected String fazAutenticacao(HttpServletRequest request) {
		String usuario = request.getParameter("apelido");
		String senha = request.getParameter("senha");
		UsuarioServico usuarioServico = new UsuarioServico();
		return usuarioServico.encontrar(usuario, senha);
	}
}
