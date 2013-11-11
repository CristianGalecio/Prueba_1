package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Laboratorio;

public class LaboratorioDAO extends DaoGenericImpl<Laboratorio, Integer>{
	
	public LaboratorioDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Laboratorio> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Laboratorio> aux =  entityManager.createQuery("SELECT l FROM Laboratorio l").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Laboratorio getLaboratorioByIdlaboratorio(int idLaboratorio) {
		Laboratorio trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Laboratorio> aux =  entityManager.createQuery("SELECT l FROM Laboratorio l WHERE l.idLaboratorio = "+idLaboratorio).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
