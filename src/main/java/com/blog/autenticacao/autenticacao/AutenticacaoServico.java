package com.blog.autenticacao.autenticacao;

import javax.servlet.http.HttpServletRequest;

import com.blog.usuario.UsuarioServico;

public class AutenticacaoServico {

	protected String fazAutenticacao(HttpServletRequest requisicao) {
		String usuario = requisicao.getParameter("apelido");
		String senha = requisicao.getParameter("senha");
		UsuarioServico usuarioServico = new UsuarioServico();
		return usuarioServico.encontrar(usuario, senha);
	}
}
