package com.blog.topico;

import java.util.List;

import javax.persistence.EntityManager;

import com.blog.nucleo.ConexaoFabrica;

public class TopicoDaoJpa implements TopicoDao {

	private static TopicoDaoJpa instance;
	private EntityManager entityManager;

	public static TopicoDaoJpa pegaInstancia() {
		if (instance == null) {
			instance = new TopicoDaoJpa();
		}
		return instance;
	}

	private TopicoDaoJpa() {
		entityManager = ConexaoFabrica.pegaGerenciadorEntidade();
	}

	@Override
	public Topico inserir(Topico topico) {
		Topico novoTopico = topico;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(novoTopico);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			novoTopico = null;
		}
		return novoTopico;
	}

	@Override
	public Topico encontrarPeloIdentificador(Long identificador) {
		return entityManager.find(Topico.class, identificador);
	}

	@Override
	public List<Topico> encontrarTodos() {
		return entityManager.createQuery("FROM " + Topico.class.getName()).getResultList();
	}

	@Override
	public Topico atualizar(Topico atual, Topico novo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean apaga(Topico topico) {
		Boolean result = true;
		try {
			entityManager.getTransaction().begin();
			Topico topicoParaDeletar = entityManager.find(Topico.class, topico.getIdentificador());
			entityManager.remove(topicoParaDeletar);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			result = false;
		}
		return result;
	}

	@Override
	public boolean apagaPeloIdentificador(Long identificador) {
		Boolean result = true;
		try {
			Topico topico = encontrarPeloIdentificador(identificador);
			apaga(topico);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		return result;
	}

}
