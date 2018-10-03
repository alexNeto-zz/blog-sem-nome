package com.blog.comentario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.blog.nucleo.ConexaoFabrica;

public class ComentarioDaoJpa implements ComentarioDao{
	
	private static ComentarioDaoJpa instance;
	private EntityManager entityManager;

	public static ComentarioDaoJpa pegaInstancia() {
		if (instance == null) {
			instance = new ComentarioDaoJpa();
		}
		return instance;
	}

	private ComentarioDaoJpa() {
		entityManager = ConexaoFabrica.getEntityManager();
	}

	@Override
	public Comentario inserir(Comentario Comentario) {
		Comentario novoComentario = Comentario;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(novoComentario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			novoComentario = null;
		}
		return novoComentario;
	}

	@Override
	public Comentario encontrarPeloIdentificador(Long id) {
		return entityManager.find(Comentario.class, id);
	}

	public List<Comentario> encontrarPeloIdentificadorTopico(Long identificador) {
		TypedQuery<Comentario> query = entityManager.createQuery(
				"FROM Comentario u WHERE u.identificadorTopico=:identificadorTopico", Comentario.class);
		query.setParameter("identificadorTopico", identificador);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Comentario> encontrarTodos() {
		return entityManager.createQuery("FROM " + Comentario.class.getName()).getResultList();
	}

	@Override
	public Comentario atualizar(Comentario atual, Comentario novo) {
		// TODO - implements
		return null;
	}

	@Override
	public boolean apaga(Comentario Comentario) {
		Boolean result = true;
		try {
			entityManager.getTransaction().begin();
			Comentario ComentarioParaDeletar = entityManager.find(Comentario.class, Comentario.getIdentificador());
			entityManager.remove(ComentarioParaDeletar);
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
			Comentario Comentario = encontrarPeloIdentificador(id);
			apaga(Comentario);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		return result;
	}

}
