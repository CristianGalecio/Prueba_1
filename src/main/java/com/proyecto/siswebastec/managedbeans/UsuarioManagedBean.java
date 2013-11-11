package com.proyecto.siswebastec.managedbeans;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.primefaces.context.RequestContext;

import com.proyecto.siswebastec.model.Usuario;
import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.UsuarioService;
import com.proyecto.siswebastec.servicesImpl.UsuarioServiceImpl;

public class UsuarioManagedBean implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UsuarioService usuarioService;
	
	private int usuario ;
	private String clave;
	private boolean logeado = false;

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}		

}
