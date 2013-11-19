package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Prioridad;

public class PrioridadDAO extends DaoGenericImpl<Prioridad, Integer>{
	
	public PrioridadDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Prioridad> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Prioridad> aux =  entityManager.createQuery("SELECT p FROM Prioridad p").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

}
