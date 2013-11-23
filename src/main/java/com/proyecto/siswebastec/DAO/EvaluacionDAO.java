package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Evaluacion;

public class EvaluacionDAO extends DaoGenericImpl<Evaluacion, Integer>{
	
	public EvaluacionDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Evaluacion getAtencionByIdEvaluacion(int idEvaluacion) {
		Evaluacion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Evaluacion> aux =  entityManager.createQuery("SELECT s FROM Evaluacion s WHERE s.idEvaluacion = "+idEvaluacion).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
	public void insertarEvaluacion(Evaluacion eval){
		entityManager.getTransaction().begin(); 
		entityManager.persist(eval);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}
