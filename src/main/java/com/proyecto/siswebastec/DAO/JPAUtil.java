package com.proyecto.siswebastec.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class JPAUtil {
	
	EntityManagerFactory aux;
	EntityManager entityManager;
	
	public JPAUtil() {
		super();
		aux = Persistence.createEntityManagerFactory("siswebastecPU");
		entityManager = aux.createEntityManager();
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
	
}
