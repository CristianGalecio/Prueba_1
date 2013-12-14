package com.proyecto.siswebastec.DAO;

import javax.persistence.EntityManager;
import com.proyecto.siswebastec.model.Solucion;

public class SolucionDAO extends DaoGenericImpl<Solucion, Integer>{
	
	public SolucionDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public void insertarSolucion(Solucion sol) {
		entityManager.getTransaction().begin();
		entityManager.persist(sol);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}
