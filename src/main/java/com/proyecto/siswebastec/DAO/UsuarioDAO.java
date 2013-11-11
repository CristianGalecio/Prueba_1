package com.proyecto.siswebastec.DAO;


import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Usuario;
import com.proyecto.siswebastec.DAO.DaoGenericImpl;

public class UsuarioDAO extends DaoGenericImpl<Usuario, String>{

		public UsuarioDAO(EntityManager entityManager) {
			super(entityManager);
			
		}
		
		public List<Usuario> listarTodos() {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Usuario> aux =  entityManager.createQuery("SELECT p FROM Usuario p").getResultList();
			//System.out.println(aux.get(1).getDescripcion());
			entityManager.getTransaction().commit();
			entityManager.close();	
			return aux;
		}

		public Usuario getUsuarioById(int id) {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Usuario> aux =  entityManager.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario="+id).getResultList();
			//System.out.println(aux.get(1).getDescripcion());
			entityManager.getTransaction().commit();
			entityManager.close();	
			return aux.get(0);
		}
		

}
