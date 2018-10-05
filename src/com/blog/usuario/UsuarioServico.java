package com.blog.usuario;

import java.util.List;

import com.blog.comentario.Comentario;
import com.blog.comentario.ComentarioDao;
import com.blog.comentario.ComentarioDaoJpa;
import com.blog.nucleo.TipoUsuario;

public class UsuarioServico {

	private UsuarioDao usuarioRepositorio;

	public UsuarioServico() {
		this.usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
	}

	public String encontrar(String apelido, String senha) {
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

	public void apagaUsuario(Long identificador) {
		UsuarioDao usuarioRepositorio = UsuarioDaoJpa.pegaInstancia();
		ComentarioDao comentarioRepositorio = ComentarioDaoJpa.pegaInstancia();
		Usuario usuario = usuarioRepositorio.encontrarPeloIdentificador(identificador);
		if (usuario.getTipoUsuario() != TipoUsuario.ADM) {
			List<Comentario> comentarios = comentarioRepositorio.encontrarPeloApelido(usuario.getApelido());
			comentarios.forEach(item -> comentarioRepositorio.apaga(item));
			usuarioRepositorio.apaga(usuario);
		}
	}
}
