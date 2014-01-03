package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
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
	private boolean secre = false;

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
				
				if(trabajadorService.verificarSecretaria(usuario)){
					if(trabajadorService.verificarTrabajador(usuario, clave)){					
						logeado = true;
						secre = true;
						msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenida", usuario);
					}else{
						logeado = false;
						secre = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave incorrecta", usuario);
					}
				}else{
					if(trabajadorService.verificarTrabajador(usuario, clave)){					
						logeado = true;
						secre = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ Soportin@", usuario);
					}else{
						logeado = false;
						secre = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave incorrecta", usuario);
					}
				}
								
			}else{
				if(tipo.equals("cliente")){
					if(clienteService.verificarCliente(usuario, clave)){
						logeado = true;
						secre = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario);
					}else{
						logeado = false;
						secre = false;
						msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Clave incorrecta", usuario);
					}					
				}else{					
					logeado = false;
					secre = false;
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error","Credenciales no v�lidas");
				}				
			}
			System.out.println(secre);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("estaLogeado", logeado);
			
			if (logeado && tipo.equals("cliente")){				
				context.addCallbackParam("view", "/Prueba_1/pages/regSolGenerar.xhtml");
			}else{
				if(logeado && tipo.equals("trabajador")){
					if(logeado && secre){
						context.addCallbackParam("view", "/Prueba_1/pages/regSolGenerarTS.xhtml");
					}else{
						context.addCallbackParam("view", "/Prueba_1/pages/regSolVisualizarT.xhtml");
					}
				}
			}		
	}
	
	/*public String navedata(){
		 Flash flash = FacesContext.getCurrentInstance().  
	              getExternalContext().getFlash();  
		 flash.put("user", usuario);  
	     flash.put("pass",clave);
		return "";
	}*/
}
