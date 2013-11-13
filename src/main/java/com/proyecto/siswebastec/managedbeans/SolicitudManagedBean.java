package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.proyecto.siswebastec.model.Area;
import com.proyecto.siswebastec.model.Aula;
import com.proyecto.siswebastec.model.Cliente;
import com.proyecto.siswebastec.model.Laboratorio;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Ubicacion;
import com.proyecto.siswebastec.services.ClienteService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.services.UbicacionService;
import com.proyecto.siswebastec.services.UsuarioService;
import com.proyecto.siswebastec.servicesImpl.ClienteServiceImpl;
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
	//Flash n;
	
	UbicacionService ubicacionService;
	SolicitudService solicitudService;
	ClienteService clienteService;
	
	public SolicitudManagedBean() {
		ubicacionService = new UbicacionServiceImpl();
		ubicaciones = ubicacionService.getNombreUbi();
		solicitudService = new SolicitudServiceImpl();
		clienteService = new ClienteServiceImpl(); 		
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
		LoginBean lb = new LoginBean();	
		Date Fecha = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		sdf.format(Fecha);
		//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fechaaaa:"+sdf.format(Fecha), nombre);
		//FacesContext.getCurrentInstance().addMessage(null, msg);
		Ubicacion ubi = ubicacionService.getNombreByNombre(getNombre());
		System.out.println(lb.getUsuario());
		Cliente cliente = clienteService.getClienteById(lb.getUsuario());
		Solicitud solNueva = new Solicitud();
		solNueva.setCliente(cliente);
		solNueva.setUbicacion(getNombre());
		solNueva.setIdUbicacion(ubi);
		solNueva.setDescSolicitud(getDescripcion());
		solNueva.setFechaIngreso(Fecha);
		
		System.out.println("Cliente:"+cliente.getNombreUsuario());
		System.out.println("Nombre:"+getNombre());
		System.out.println("Ubicacion:"+ubi.getNombreUbicacion());
		System.out.println("Descripcion:"+getDescripcion());
		System.out.println("Fechaaaa:"+sdf.format(Fecha));
		
	}
	
	public void cancelar(){
		
	}
	
	public String grabar(){
		return "Holitas";
	}
	

}
