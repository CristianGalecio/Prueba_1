package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.UsuarioService;
import com.proyecto.siswebastec.servicesImpl.UsuarioServiceImpl;

public class ClienteManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
		ClienteService clienteService;
			
		private String cliente;
		private String clave;
		private boolean logeado = false;
				
		public ClienteService getUsuarioService() {
			return clienteService;
		}

		public void setClienteService(ClienteService clienteService) {
			this.clienteService = clienteService;
		}

		public String getCliente() {
			return cliente;
		}
		public void Cliente(String cliente) {
			this.cliente = cliente;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}		

}
