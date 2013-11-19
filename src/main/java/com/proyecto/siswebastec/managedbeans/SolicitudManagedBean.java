package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.proyecto.siswebastec.model.Area;
import com.proyecto.siswebastec.model.Aula;
import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Estado;
import com.proyecto.siswebastec.model.Laboratorio;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.TipoSolicitud;
import com.proyecto.siswebastec.model.Ubicacion;
import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.LoginService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.services.UbicacionService;
import com.proyecto.siswebastec.services.UsuarioService;
import com.proyecto.siswebastec.servicesImpl.ClienteServiceImpl;
import com.proyecto.siswebastec.servicesImpl.LoginServiceImpl;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.servicesImpl.UbicacionServiceImpl;
import com.proyecto.siswebastec.servicesImpl.UsuarioServiceImpl;

public class SolicitudManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ubicacion;
	private List<String> ubicaciones;
	private String nombre;
	private List<String> nombres;
	private String descripcion;
	private String usuario;
	//Flash n;
	
	UbicacionService ubicacionService;
	SolicitudService solicitudService;
	ClienteService clienteService;
	LoginService loginService;
	
	public SolicitudManagedBean() {
		ubicacionService = new UbicacionServiceImpl();
		ubicaciones = ubicacionService.getNombreUbi();
		solicitudService = new SolicitudServiceImpl();
		clienteService = new ClienteServiceImpl(); 
		loginService = new LoginServiceImpl();
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public List<String> getUbicaciones() {
		return ubicaciones;
	}
	
	public void setUbicaciones(List<String> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<String> getNombres() {
		return nombres;
	}
	
	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<List<String>> UbicacionNombre(){
		List<List<String>> ubns = new ArrayList<>();
		ubns.add(0,ubicacionService.getNombreAreas());
		ubns.add(1, ubicacionService.getNombreAulas());
		ubns.add(2, ubicacionService.getNombreLabos());
		return ubns;
	}
	
	public void handleUbicacionChange() {  
        List<List<String>> ubns = UbicacionNombre();
		if(ubicacion !=null && !ubicacion.equals(""))  
            if(ubicacion.equals("Area")){
            	nombres = ubns.get(0);
            }
			if(ubicacion.equals("Aula")){
            	nombres = ubns.get(1);
			}
			if(ubicacion.equals("Laboratorio")){
            	nombres = ubns.get(2);
			}               
    }
	
	public void guardar(ActionEvent actionEvent){
		//RequestContext context = RequestContext.getCurrentInstance();
		//Comunicacion entre ManagedBean
		FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		LoginBean nB =(LoginBean) session.getAttribute("loginBean");	
		Date Fecha = Calendar.getInstance().getTime();
		Cliente cliente;
		//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fechaaaa:"+sdf.format(Fecha), nombre);
		//FacesContext.getCurrentInstance().addMessage(null, msg);
		String tipo = loginService.DevolverTipoUsuario(nB.getUsuario(), nB.getClave());
		System.out.println(tipo);
		if(tipo.equals("cliente")){
			cliente = clienteService.getClienteById(nB.getUsuario());
		}else{
			System.out.println(getUsuario());
			cliente = clienteService.getClienteById(getUsuario());
		}		
		
		Estado est=new Estado(1,"pendiente");
		TipoSolicitud tip = new TipoSolicitud(1,"normal");
		Ubicacion ubi = ubicacionService.getNombreByNombre(getUbicacion());
		Solicitud solNueva = new Solicitud();
		solNueva.setCliente(cliente);
		solNueva.setUbicacion(getNombre());
		solNueva.setIdUbicacion(ubi);
		solNueva.setDescSolicitud(getDescripcion());
		solNueva.setIdSolicitante(nB.getUsuario());
		solNueva.setFechaIngreso(Fecha);
		solNueva.setFechaCierre(Fecha);
		solNueva.setHoraIngreso(Fecha);
		solNueva.setHoraCierre(Fecha);
		solNueva.setIdEstado(est);
		solNueva.setIdTipo(tip);
		
		solicitudService.addSolicitud(solNueva);		
	}
	
	public void cancelar(ActionEvent actionEvent){
		setDescripcion("");
		setNombre("");
		//setNombres(nombres);
		setUbicacion("");
		setUsuario("");
	}
	
	public String cambiarPagGen(){
		return "regSolGenerar?faces-redirect=true";
	}
	
	public String cambiarPagVis(){
		return "regSolVisualizar?faces-redirect=true";
	}
	
	public String cambiarPagGenT(){
		return "regSolGenerarT?faces-redirect=true";
	}
	
	public String cambiarPagVisT(){
		return "regSolVisualizarT?faces-redirect=true";
	}
	
}
