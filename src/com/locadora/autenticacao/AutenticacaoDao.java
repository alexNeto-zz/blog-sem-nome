package com.locadora.autenticacao;

import java.util.List;

import com.locadora.usuario.Usuario;

public interface AutenticacaoDao {
	public Usuario insert(Usuario usuario);

	public Usuario findById(Long id);

	public Usuario findByNomeUsuario(String nomeUsuario);

	public Usuario findByName(String name);

	public List<Usuario> findAll();

	public Usuario update(Usuario usuarioAnt, Usuario usuarioAt);

	public boolean delete(Usuario usuario);

	public boolean delete(Long id);
	}
