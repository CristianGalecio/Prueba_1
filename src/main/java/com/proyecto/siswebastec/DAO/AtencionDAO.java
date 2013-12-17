package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Estado;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.TipoSolicitud;

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

	public Atencion buscarAtencion(int idSol) {
		System.out.println("AtencionDAO.buscarAtencion()");
		System.out.println(idSol);
		Atencion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Atencion> aux =  entityManager.createQuery("SELECT s FROM Atencion s WHERE s.idSolicitud.idSolicitud = "+idSol).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
			System.out.println(aux.size());
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	public TipoSolicitud buscarTipoSol(int idTipo) {
		System.out.println(idTipo);
		TipoSolicitud trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<TipoSolicitud> aux =  entityManager.createQuery("SELECT s FROM TipoSolicitud s WHERE s.idTipo= "+idTipo).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
			System.out.println(aux.size());
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

	public Estado buscarEstado(int idEstado) {
		System.out.println(idEstado);
		Estado trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Estado> aux =  entityManager.createQuery("SELECT s FROM Estado s WHERE s.idEstado= "+idEstado).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
			System.out.println(aux.size());
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
