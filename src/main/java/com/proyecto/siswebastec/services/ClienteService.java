package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Cliente;

public interface ClienteService {
	
	public void addCliente(Cliente usuario);	
	public void updateCliente(Cliente usuario);
	public void deleteCliente(Cliente usuario);	
	public Cliente getClienteById(String id);	
	public List<Cliente> getClientes();	
	public Boolean verificarCliente(String id, String password);
	
}
