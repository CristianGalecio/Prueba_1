package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.model.TrabajadorPK;
import com.proyecto.siswebastec.model.Usuario;

public class TrabajadorDAO extends DaoGenericImpl<Trabajador, String>{
	
	public TrabajadorDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<Trabajador> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Trabajador> aux =  entityManager.createQuery("SELECT t FROM Trabajador t").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Trabajador getTrabajadorByIdtrabajador(String idTrabajador) {
		Trabajador trb = null;
		entityManager.getTransaction().begin();		
		@SuppressWarnings("unchecked")
		List<Trabajador> aux =  entityManager.createQuery("SELECT t FROM Trabajador t WHERE t.trabajadorPK.idTrabajador = '"+idTrabajador+"'").getResultList();
		if(aux.size()!=0){
			trb=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return trb;
	}

}
