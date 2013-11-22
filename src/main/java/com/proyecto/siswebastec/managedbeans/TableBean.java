package com.proyecto.siswebastec.managedbeans;

import com.proyecto.siswebastec.services.AtencionService;
import com.proyecto.siswebastec.services.PrioridadService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.servicesImpl.AtencionServiceImpl;
import com.proyecto.siswebastec.servicesImpl.PrioridadServiceImpl;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.servicesImpl.TrabajadorServiceImpl;
import com.proyecto.siswebastec.bean.SolicitudDataModel;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Trabajador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

public class TableBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Solicitud> solicitudes,solicitudespend,solicitudespro,solicitudesfin;
	private SolicitudService solserv;
	private Solicitud selectedSol;
	private SolicitudDataModel mediumSolsModel,mediumSolsModelPro,mediumSolsModelFin; 
	private Solicitud fija;
	
	private String prioridad;
	private String trabajador;
//    private List<Prioridad> prioridades;  
    private List<String> prinames;
    private List<String> traid;
    private PrioridadService prioridadService;
    private TrabajadorService trabajadorService;
    private AtencionService atencionService;
	
	public TableBean(){
		System.out.println("TableBean.TableBean()");
		solicitudes=new ArrayList<Solicitud>();
		solserv=new SolicitudServiceImpl();
		solicitudespend=new ArrayList<Solicitud>();
		solicitudespend = solserv.getSolicitudesPendientes();
		solicitudespro=new ArrayList<Solicitud>();
		solicitudespro = solserv.getSolicitudesProceso();
		solicitudesfin=new ArrayList<Solicitud>();
		solicitudesfin=solserv.getSolicitudesFinalizadas();
		mediumSolsModel= new SolicitudDataModel(solicitudespend);
		mediumSolsModelPro=new SolicitudDataModel(solicitudespro);
		mediumSolsModelFin=new SolicitudDataModel(solicitudesfin);
		
		
		prioridadService = new PrioridadServiceImpl();
    	trabajadorService = new TrabajadorServiceImpl();
  //  	prioridades = new ArrayList<>();
  //  	prioridades = prioridadService.getPrioridades();
    	prinames = new ArrayList<>();
    	traid = new ArrayList<>();
    	prinames = prioridadService.getNombresPri();
    	traid = trabajadorService.getIdTrabajadores();
    	atencionService = new AtencionServiceImpl();
		
//		System.out.println("Holitas!");
	}
	
	public List<Solicitud> getSolicitudespend() {
		System.out.println("TableBean.getSolicitudespend()");
		solserv=new SolicitudServiceImpl();
		setSolicitudespend(solserv.getSolicitudesPendientes());		
		return this.solicitudespend;
	}

	public void setSolicitudespend(List<Solicitud> solicitudespend) {
		System.out.println("TableBean.setSolicitudespend()");
		this.solicitudespend = solicitudespend;
	}

	public List<Solicitud> getSolicitudespro() {
		System.out.println("TableBean.getSolicitudespro()");
		
		solserv=new SolicitudServiceImpl();
		setSolicitudespro(solserv.getSolicitudesProceso());
		return solicitudespro;
	}

	public SolicitudDataModel getMediumSolsModelPro() {
		return mediumSolsModelPro;
	}

	public void setMediumSolsModelPro(SolicitudDataModel mediumSolsModelPro) {
		this.mediumSolsModelPro = mediumSolsModelPro;
	}

	public void setSolicitudespro(List<Solicitud> solicitudespro) {
		System.out.println("TableBean.setSolicitudespro()");
		this.solicitudespro = solicitudespro;
	}

	public List<Solicitud> getSolicitudesfin() {
		System.out.println("TableBean.getSolicitudesfin()");
		solserv=new SolicitudServiceImpl();
		setSolicitudesfin(solserv.getSolicitudesFinalizadas());
		return solicitudesfin;
	}

	public void setSolicitudesfin(List<Solicitud> solicitudesfin) {
		System.out.println("TableBean.setSolicitudesfin()");
		this.solicitudesfin = solicitudesfin;
	}

	public List<Solicitud> getSolicitudes() {
		System.out.println("TableBean.getSolicitudes()");
		return solicitudes;
	}
	
	public void setSolicitudes(List<Solicitud> solicitudes) {
		System.out.println("TableBean.setSolicitudes()");
		this.solicitudes = solicitudes;
	}
	
	public SolicitudService getSolserv() {
		System.out.println("TableBean.getSolserv()");
		return solserv;
	}
	
	public void setSolserv(SolicitudService solserv) {
		System.out.println("TableBean.setSolserv()");
		this.solserv = solserv;
	}	
	
	public Solicitud getSelectedSol() {
		System.out.println("TableBean.getSelectedSol()");
		return selectedSol;
	}

	public void setSelectedSol(Solicitud selectedSol) {
		System.out.println("TableBean.setSelectedSol()");
		this.selectedSol = selectedSol;
	}

	public SolicitudDataModel getMediumSolsModel() {
		System.out.println("TableBean.getMediumSolsModel()");
		return mediumSolsModel;
	}

	public SolicitudDataModel getMediumSolsModelFin() {
		return mediumSolsModelFin;
	}

	public void setMediumSolsModelFin(SolicitudDataModel mediumSolsModelFin) {
		this.mediumSolsModelFin = mediumSolsModelFin;
	}

	public void setMediumSolsModel(SolicitudDataModel mediumSolsModel) {
		System.out.println("TableBean.setMediumSolsModel()");
		this.mediumSolsModel = mediumSolsModel;
	}

	public void onRowSelect(SelectEvent event) {
		System.out.println("TableBean.onRowSelect()");
		System.out.println(event.getObject());
		fija = (Solicitud) event.getObject();
        //FacesMessage msg = new FacesMessage("Sol Selected",((Solicitud) event.getObject()).getIdSolicitud().toString());  
  
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onRowUnselect(UnselectEvent event) {
    	System.out.println("TableBean.onRowUnselect()");
        FacesMessage msg = new FacesMessage("Sol Unselected", ((Solicitud) event.getObject()).getIdSolicitud().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
        
    
    public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public List<String> getPrinames() {		
		prioridadService = new PrioridadServiceImpl();
		setPrinames(prioridadService.getNombresPri());
		return prinames;
	}
	
	
	public void setPrinames(List<String> prinames) {
		this.prinames = prinames;
	}

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public List<String> getTraid() {
		return traid;
	}

	public void setTraid(List<String> traid) {
		this.traid = traid;
	}
	
	public void asignarTecnico(ActionEvent actionEvent){
		System.out.println("TableBean.asignarTecnico()");
		Trabajador t = trabajadorService.getTrabajadorById(getTrabajador());
		Date Fecha = Calendar.getInstance().getTime();
		System.out.println("Prioridad"+getPrioridad());
		System.out.println("Hooooooola fija"+ fija.getDescSolicitud());
		Prioridad p = new Prioridad();
		
		p.setNombrePrioridad(getPrioridad());
		
		if(getPrioridad().equals("alta")){
			p.setIdPrioridad(1);			
		}
		if(getPrioridad().equals("media")){
			p.setIdPrioridad(2);			
		}
		if(getPrioridad().equals("baja")){
			p.setIdPrioridad(3);			
		}
		
		Solicitud sasig = fija;
		System.out.println("Solicitud"+sasig.getDescSolicitud());
		sasig.setIdPrioridad(p);		
		solserv.updateSolicitud(sasig);
		
		//Creamos la atencion
		
		Atencion ate = new Atencion();
		ate.setIdSolicitud(sasig);
		ate.setFechaAtencion(Fecha);
		ate.setHoraAtencion(Fecha);
		ate.setTrabajador(t);
		atencionService.addAtencion(ate);		
		
	}
	
	public void SeleccionaSolicitud(){
		
	}
	
	public void handleChangeP() {  
		System.out.println("evento: "+prioridad);
    }
	
	
}
