package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Aula;

public class AulaDAO extends DaoGenericImpl<Aula, Integer>{
	
	public AulaDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Aula> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Aula> aux =  entityManager.createQuery("SELECT a FROM Aula a").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Aula getAulaByIdaula(int idAula) {
		Aula trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Aula> aux =  entityManager.createQuery("SELECT a FROM Aula a WHERE a.idAula = "+idAula).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
