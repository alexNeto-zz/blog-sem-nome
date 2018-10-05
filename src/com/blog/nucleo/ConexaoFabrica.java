package com.blog.nucleo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFabrica {

	private static EntityManager gerenciadorEntidade;

	public static EntityManager pegaGerenciadorEntidade() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog-pu");
		if (gerenciadorEntidade == null) {
			gerenciadorEntidade = factory.createEntityManager();
		}

		return gerenciadorEntidade;
	}
}
