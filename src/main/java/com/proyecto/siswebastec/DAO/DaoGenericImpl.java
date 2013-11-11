package com.proyecto.siswebastec.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


import javax.persistence.EntityManager;

public class DaoGenericImpl<T, PK extends Serializable> 
implements DaoGenerica<T, Serializable>{
	
	
	EntityManager entityManager;
	Class<T> entidad;
	

	@SuppressWarnings("unchecked")
	public DaoGenericImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		 ParameterizedType genericSuperclass = (ParameterizedType) getClass()
	             .getGenericSuperclass();
		 	
	        this.entidad = (Class<T>)genericSuperclass.getActualTypeArguments()[0];
	}

		
	public T create(T t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
		return null;
	}

	public T read(Serializable id) {
		entityManager.getTransaction().begin();
		return (T) entityManager.find(entidad, id);
	}
	
	
	public T update(T t) {
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
        return t;
	}

	public void delete(T t) {
		entityManager.getTransaction().begin();
		t = entityManager.merge(t);
	    entityManager.remove(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}


}