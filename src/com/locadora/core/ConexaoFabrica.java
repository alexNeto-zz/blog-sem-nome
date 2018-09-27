package com.locadora.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoFabrica {

	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadora-pu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
}
