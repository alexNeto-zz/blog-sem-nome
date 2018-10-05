package com.blog.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.blog.nucleo.ConexaoFabrica;

public class UsuarioDaoJpa implements UsuarioDao {

	private static UsuarioDaoJpa instance;
	private EntityManager entityManager;

	public static UsuarioDaoJpa pegaInstancia() {
		if (instance == null) {
			instance = new UsuarioDaoJpa();
		}
		return instance;
	}

	private UsuarioDaoJpa() {
		entityManager = ConexaoFabrica.pegaGerenciadorEntidade();
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

	public Usuario encontrarPeloNome(String apelido) {
		TypedQuery<Usuario> query = entityManager.createQuery(
				"FROM Usuario u WHERE u.apelido=:apelido", Usuario.class);
		query.setParameter("apelido", apelido);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
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
			Usuario usuarioParaDeletar = entityManager.find(Usuario.class, usuario.getIdentificador());
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