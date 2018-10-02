package com.blog.usuario;

public class UsuarioServico {

	private UsuarioDao usuarioRepositorio;

	public UsuarioServico() {
		this.usuarioRepositorio = UsuarioDaoJpa.getInstance();
	}

	public String encontrar(String nomeUsuario, String senha) {
		Usuario usuario = usuarioRepositorio.encontrarPeloNome(nomeUsuario);
		if (usuarioValido(usuario, nomeUsuario, senha))
			return usuario.getApelido();
		else
			return null;
	}

	private Boolean usuarioValido(Usuario usuario, String nomeUsuario, String senha) {
		Boolean result = true;
		if (usuario == null)
			result = false;
		else {
			if (!usuario.getApelido().equals(nomeUsuario))
				result = false;
			if (!usuario.getSenha().equals(senha)) {
				result = false;
			}
		}
		return result;
	}
}
