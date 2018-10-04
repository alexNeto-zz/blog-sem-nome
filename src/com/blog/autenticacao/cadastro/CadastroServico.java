package com.blog.autenticacao.cadastro;

import javax.servlet.http.HttpServletRequest;

import com.blog.usuario.UsuarioServico;

public class CadastroServico {
	
	protected String fazCadastro(HttpServletRequest request) {
		String usuario = request.getParameter("nomeUsuario");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		UsuarioServico usuarioServico = new UsuarioServico();
		return usuarioServico.encontrar(usuario, senha);
	}

}
