package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Ubicacion;

public class UbicacionDAO extends DaoGenericImpl<Ubicacion, Integer>{
	
	public UbicacionDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Ubicacion> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Ubicacion> aux =  entityManager.createQuery("SELECT u FROM Ubicacion u").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Ubicacion getUbicacionByIdubicacion(int idUbicacion) {
		Ubicacion trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Ubicacion> aux =  entityManager.createQuery("SELECT u FROM Ubicacion u WHERE u.idUbicacion = "+idUbicacion).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
