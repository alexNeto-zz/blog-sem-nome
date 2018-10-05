package com.blog.comentario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.blog.nucleo.ConexaoFabrica;

public class ComentarioDaoJpa implements ComentarioDao{
	
	private static ComentarioDaoJpa instancia;
	private EntityManager gerenciadorEntidade;

	public static ComentarioDaoJpa pegaInstancia() {
		if (instancia == null) {
			instancia = new ComentarioDaoJpa();
		}
		return instancia;
	}

	private ComentarioDaoJpa() {
		gerenciadorEntidade = ConexaoFabrica.pegaGerenciadorEntidade();
	}

	@Override
	public Comentario inserir(Comentario Comentario) {
		Comentario novoComentario = Comentario;
		try {
			gerenciadorEntidade.getTransaction().begin();
			gerenciadorEntidade.persist(novoComentario);
			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			gerenciadorEntidade.getTransaction().rollback();
			novoComentario = null;
		}
		return novoComentario;
	}

	@Override
	public Comentario encontrarPeloIdentificador(Long id) {
		return gerenciadorEntidade.find(Comentario.class, id);
	}

	@Override
	public List<Comentario> encontrarPeloIdentificadorTopico(Long identificador) {
		TypedQuery<Comentario> query = gerenciadorEntidade.createQuery(
				"FROM Comentario u WHERE u.identificadorTopico=:identificadorTopico", Comentario.class);
		query.setParameter("identificadorTopico", identificador);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<Comentario> encontrarPeloApelido(String apelido) {
		TypedQuery<Comentario> query = gerenciadorEntidade.createQuery(
				"FROM Comentario u WHERE u.apelido=:apelido", Comentario.class);
		query.setParameter("apelido", apelido);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}


	@Override
	public List<Comentario> encontrarTodos() {
		return gerenciadorEntidade.createQuery("FROM " + Comentario.class.getName()).getResultList();
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
			gerenciadorEntidade.getTransaction().begin();
			Comentario ComentarioParaDeletar = gerenciadorEntidade.find(Comentario.class, Comentario.getIdentificador());
			gerenciadorEntidade.remove(ComentarioParaDeletar);
			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			gerenciadorEntidade.getTransaction().rollback();
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
