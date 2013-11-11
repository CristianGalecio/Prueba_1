package com.proyecto.siswebastec.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Usuario;

public class ClienteDAO extends DaoGenericImpl<Cliente, String>{

	public ClienteDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	public List<Cliente> listarTodos() {
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Cliente> aux =  entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
		//System.out.println(aux.get(1).getDescripcion());
		entityManager.getTransaction().commit();
		entityManager.close();	
		return aux;
	}

	public Cliente getClienteByIdcliente(String idCliente) {
		Cliente cli = null;
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Cliente> aux =  entityManager.createQuery("SELECT c FROM Cliente c WHERE c.clientePK.idCliente ='"+idCliente+"'").getResultList();
		if(aux.size()!=0){
			cli=aux.get(0);
		}
		entityManager.getTransaction().commit();
		entityManager.close();	
		return cli;
	}
	
}
