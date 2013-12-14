package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Diagnostico;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Solucion;

public class DiagnosticoDAO extends DaoGenericImpl<Diagnostico, Integer>{

	public DiagnosticoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Diagnostico getDiagnosticoById(int id) {
		Diagnostico trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Diagnostico> aux =  entityManager.createQuery("SELECT s FROM Diagnostico s WHERE s.idDiagnostico = "+id).getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}
	
	public void insertarDiagnostico(Diagnostico diag) {
		entityManager.getTransaction().begin();
		entityManager.persist(diag);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
}
