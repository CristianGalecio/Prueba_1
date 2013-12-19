package com.proyecto.siswebastec.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import com.proyecto.siswebastec.model.RolUsuario;

public class RolUsuarioDAO extends DaoGenericImpl<RolUsuario, Integer>{
	
	public RolUsuarioDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	public List<RolUsuario> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<RolUsuario> aux =  entityManager.createQuery("SELECT t FROM RolUsuario t").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}
	
	public RolUsuario getRolUsuariobyIdUsuario(int id){
		RolUsuario ru = null;
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<RolUsuario> aux =  entityManager.createQuery("SELECT t FROM RolUsuario t WHERE t.idUsuario.idUsuario="+id).getResultList();
		if(aux.size()!=0){
			ru=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return ru;
	}
}
