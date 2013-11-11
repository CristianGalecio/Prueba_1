package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Area;

public class AreaDAO extends DaoGenericImpl<Area, Integer>{
	
	public AreaDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Area> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Area> aux =  entityManager.createQuery("SELECT a FROM Area a").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Area getAreaByIdarea(int idArea) {
		Area trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Area> aux =  entityManager.createQuery("SELECT u FROM Area u WHERE u.idArea = "+idArea).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
