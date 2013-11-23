package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Calificacion;


public class CalificacionDAO extends DaoGenericImpl<Calificacion, Integer>{

	public CalificacionDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Calificacion> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Calificacion> aux =  entityManager.createQuery("SELECT c FROM Calificacion c").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Calificacion getCalificacionByIdcalificacion(int idCalf) {
		Calificacion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Calificacion> aux =  entityManager.createQuery("SELECT c FROM Calificacion c WHERE c.idCalificacion = "+idCalf).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
	public Calificacion getCalificacionByNombrecalificacion(String nombrecalf) {
		Calificacion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Calificacion> aux =  entityManager.createQuery("SELECT c FROM Calificacion c WHERE c.nombreCalificacion = '"+nombrecalf+"'").getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
			System.out.println("Calificacion ID:"+trb.getIdCalificacion());
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
}
