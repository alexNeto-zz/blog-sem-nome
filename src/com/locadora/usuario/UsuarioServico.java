package com.locadora.usuario;

public class UsuarioServico {

	private UsuarioDao usuarioRepositorio;

	public UsuarioServico() {
		this.usuarioRepositorio = UsuarioDaoJpa.getInstance();
	}

	public String encontrar(String nomeUsuario, String senha) {
		Usuario usuario = usuarioRepositorio.encontrarPeloNome(nomeUsuario);
		if (usuarioValido(usuario, nomeUsuario, senha))
			return usuario.getNomeUsuario();
		else
			return null;
	}

	private Boolean usuarioValido(Usuario usuario, String nomeUsuario, String senha) {
		Boolean result = true;
		if (!usuario.getNomeUsuario().equals(nomeUsuario))
			result = false;
		if (!usuario.getSenha().equals(senha)) {
			result = false;
		}
		return result;
	}
}
