package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.LoginService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.services.UsuarioService;
import com.proyecto.siswebastec.servicesImpl.ClienteServiceImpl;
import com.proyecto.siswebastec.servicesImpl.LoginServiceImpl;
import com.proyecto.siswebastec.servicesImpl.TrabajadorServiceImpl;
import com.proyecto.siswebastec.servicesImpl.UsuarioServiceImpl;

public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	TrabajadorService trabajadorService;
	ClienteService clienteService;
	LoginService loginService;
		
	private String usuario;
	private String clave;
	private boolean logeado = false;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean estaLogeado() {
		return logeado;
	}
	
	public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		
		trabajadorService = new TrabajadorServiceImpl();
		clienteService = new ClienteServiceImpl();
		loginService = new LoginServiceImpl();
		
		String tipo=loginService.DevolverTipoUsuario(usuario, clave);

			if(tipo.equals("trabajador")){
				if(trabajadorService.verificarTrabajador(usuario, clave)){					
					logeado = true;
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ Soportin@", usuario);
				}else{
					logeado = false;
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave incorrecta", usuario);
				}				
			}else{
				if(tipo.equals("cliente")){
					if(clienteService.verificarCliente(usuario, clave)){
						logeado = true;
						msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario);
					}else{
						logeado = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave incorrecta", usuario);
					}					
				}else{					
					logeado = false;
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error","Credenciales no válidas");
				}				
			}
			
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("estaLogeado", logeado);
			
			if (logeado && tipo.equals("cliente")){				
				context.addCallbackParam("view", "/astec/pages/registroAtencion.xhtml");
			}else{
				if(logeado && tipo.equals("trabajador")){
					context.addCallbackParam("view", "/astec/pages/registroAtencionT.xhtml");
				}
			}		
	}	
}