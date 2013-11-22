package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Diagnostico;
import com.proyecto.siswebastec.model.Solicitud;

public class DiagnosticoDAO extends DaoGenericImpl<Diagnostico, Integer>{

	public DiagnosticoDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public void insertarDiagnostico(Diagnostico diag) {
		entityManager.getTransaction().begin();
		entityManager.persist(diag);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
}
