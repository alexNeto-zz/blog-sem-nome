package com.blog.usuario;

import com.blog.core.Dao;

public interface UsuarioDao extends Dao<Usuario> {

	public Usuario encontrarPeloNome(String nomeUsuario);

}