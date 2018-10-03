package com.blog.usuario;

import com.blog.nucleo.Dao;

public interface UsuarioDao extends Dao<Usuario> {

	public Usuario encontrarPeloNome(String nomeUsuario);

}