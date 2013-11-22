package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Solicitud;

public class AtencionDAO extends DaoGenericImpl<Atencion, Integer>{
	
	public AtencionDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Atencion> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Atencion> aux =  entityManager.createQuery("SELECT s FROM Atencion s").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Atencion getAtencionByIdsolicitud(int idAtencion) {
		Atencion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Atencion> aux =  entityManager.createQuery("SELECT s FROM Atencion s WHERE s.idAtencion = "+idAtencion).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
	public void insertarAtencion(Atencion ate){
		entityManager.getTransaction().begin();
		entityManager.persist(ate);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}
