package com.locadora.usuario;

import java.util.List;

import javax.persistence.EntityManager;

import com.locadora.ConexaoFabrica;

public class UsuarioDaoJpa implements UsuarioDao {

	private static UsuarioDaoJpa instance;
	private EntityManager entityManager;

	public static UsuarioDaoJpa getInstance() {
		if (instance == null) {
			instance = new UsuarioDaoJpa();
		}
		return instance;
	}

	private UsuarioDaoJpa() {
		entityManager = ConexaoFabrica.getEntityManager();
	}

	@Override
	public Usuario inserir(Usuario usuario) {
		Usuario novoUsuario = usuario;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(novoUsuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			novoUsuario = null;
		}
		return novoUsuario;
	}

	@Override
	public Usuario encontrarPeloIdentificador(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	public Usuario encontrarPeloNome(String nomeUsuario) {
		return entityManager.find(Usuario.class, nomeUsuario);
	}

	@Override
	public List<Usuario> encontrarTodos() {
		return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}

	@Override
	public Usuario atualizar(Usuario atual, Usuario novo) {
		// TODO - implements
		return null;
	}

	@Override
	public boolean apaga(Usuario usuario) {
		Boolean result = true;
		try {
			entityManager.getTransaction().begin();
			Usuario usuarioParaDeletar = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuarioParaDeletar);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			result = false;
		}
		return result;
	}

	@Override
	public boolean apagaPeloIdentificador(Long id) {
		Boolean result = true;
		try {
			Usuario usuario = encontrarPeloIdentificador(id);
			apaga(usuario);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		return result;
	}

}