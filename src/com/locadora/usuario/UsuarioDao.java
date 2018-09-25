package com.locadora.usuario;

import java.util.List;

public interface UsuarioDao {
	public Usuario inserir(Usuario usuario);

	public Usuario encontrarPeloIdentificador(Long id);
	
	public Usuario encontrarPeloNome(String nomeUsuario);

	public List<Usuario> encontrarTodos();

	public Usuario atualizar(Usuario atual, Usuario novo);

	public boolean apaga(Usuario usuario);
	
	public boolean apagaPeloIdentificador(Long id);

}