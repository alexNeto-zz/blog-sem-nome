package com.blog.usuario;

import java.util.List;

public class UsuarioServico {

	private UsuarioDao usuarioRepositorio;

	public UsuarioServico() {
		this.usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
	}

	protected String encontrar(String apelido, String senha) {
		Usuario usuario = usuarioRepositorio.encontrarPeloNome(apelido);
		if (usuarioValido(usuario, apelido, senha))
			return usuario.getApelido();
		else
			return null;
	}

	private Boolean usuarioValido(Usuario usuario, String apelido, String senha) {
		Boolean result = true;
		if (usuario == null)
			result = false;
		else {
			if (!usuario.getApelido().equals(apelido))
				result = false;
			if (!usuario.getSenha().equals(senha)) {
				result = false;
			}
		}
		return result;
	}

	public List<Usuario> pegaTodos() {
		return usuarioRepositorio.encontrarTodos();
	}
}
