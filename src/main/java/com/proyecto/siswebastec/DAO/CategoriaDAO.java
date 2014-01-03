package com.proyecto.siswebastec.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import com.proyecto.siswebastec.model.Categoria;

public class CategoriaDAO  extends DaoGenericImpl<Categoria, Integer> {

	public CategoriaDAO(EntityManager entityManager) {
		super(entityManager);		
	}

	public List<Categoria> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Categoria> aux =  entityManager.createQuery("SELECT c FROM Categoria c").getResultList();
		System.out.println(aux.get(0));
		entityManager.getTransaction().commit();
		
		entityManager.close();	
		return aux;
	}

}
