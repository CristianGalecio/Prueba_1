package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Area;
import com.proyecto.siswebastec.model.Solicitud;

public class SolicitudDAO extends DaoGenericImpl<Solicitud, Integer>{
	
	public SolicitudDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Solicitud> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Solicitud> aux =  entityManager.createQuery("SELECT s FROM Solicitud s").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Solicitud getSolicitudByIdsolicitud(int idSolicitud) {
		Solicitud trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Solicitud> aux =  entityManager.createQuery("SELECT s FROM Solicitud s WHERE s.idSolicitud = "+idSolicitud).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
	public void insertarSolicitud(Solicitud sol){
		entityManager.getTransaction().begin();
		entityManager.persist(sol);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}

