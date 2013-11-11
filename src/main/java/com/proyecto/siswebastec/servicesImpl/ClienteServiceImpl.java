package com.proyecto.siswebastec.servicesImpl;

import java.util.List;

import com.proyecto.siswebastec.DAO.ClienteDAO;
import com.proyecto.siswebastec.DAO.JPAUtil;
import com.proyecto.siswebastec.DAO.TrabajadorDAO;
import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.services.ClienteService;

public class ClienteServiceImpl implements ClienteService{

	ClienteDAO clienteDAO;
	JPAUtil objJpaUtil;
	Cliente cliente;
	
	public ClienteServiceImpl() {
		super();
		objJpaUtil = new JPAUtil();
		clienteDAO =  new ClienteDAO(objJpaUtil.getEntityManager());
		cliente = new Cliente();
	}
		
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}


	public void addCliente(Cliente usuario) {
		// TODO Auto-generated method stub
		
	}

	public void updateCliente(Cliente usuario) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCliente(Cliente usuario) {
		// TODO Auto-generated method stub
		
	}

	public Cliente getClienteById(String id) {
		objJpaUtil =  new JPAUtil();
		clienteDAO = new ClienteDAO(objJpaUtil.getEntityManager());
		cliente = clienteDAO.getClienteByIdcliente(id);
		return cliente;
	}

	public List<Cliente> getClientes() {		
		return getClienteDAO().listarTodos();
	}

	public Boolean verificarCliente(String id, String password) {
		if(getClienteById(id).getClaveUsuario().equals(password)){
			return true;
		}else{
			return false;
		}
	}

}
