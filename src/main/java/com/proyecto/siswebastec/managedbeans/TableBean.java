package com.proyecto.siswebastec.managedbeans;

import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.bean.SolicitudDataModel;
import com.proyecto.siswebastec.model.Solicitud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

public class TableBean implements Serializable{
	private List<Solicitud> solicitudes,solicitudespend,solicitudespro,solicitudesfin;
	private SolicitudService solserv;
	private Solicitud selectedSol;
	private SolicitudDataModel mediumSolsModel; 
	public TableBean(){
		System.out.println("TableBean.TableBean()");
		solicitudes=new ArrayList<Solicitud>();
		solserv=new SolicitudServiceImpl();
		solicitudespend=new ArrayList<Solicitud>();
		solicitudespend = solserv.getSolicitudesPendientes();
		mediumSolsModel= new SolicitudDataModel(solicitudespend);
		//solicitudes=solserv.getSolicitudes();
		
//		System.out.println("Holitas!");
	}
	
	public List<Solicitud> getSolicitudespend() {
		System.out.println("TableBean.getSolicitudespend()");
		//setSolicitudespend(solserv.getSolicitudesPendientes());
		return this.solicitudespend;
	}

	public void setSolicitudespend(List<Solicitud> solicitudespend) {
		System.out.println("TableBean.setSolicitudespend()");
		this.solicitudespend = solicitudespend;
	}

	public List<Solicitud> getSolicitudespro() {
		System.out.println("TableBean.getSolicitudespro()");
		setSolicitudespro(solserv.getSolicitudesProceso());
		return solicitudespro;
	}

	public void setSolicitudespro(List<Solicitud> solicitudespro) {
		System.out.println("TableBean.setSolicitudespro()");
		this.solicitudespro = solicitudespro;
	}

	public List<Solicitud> getSolicitudesfin() {
		System.out.println("TableBean.getSolicitudesfin()");
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

	public void setMediumSolsModel(SolicitudDataModel mediumSolsModel) {
		System.out.println("TableBean.setMediumSolsModel()");
		this.mediumSolsModel = mediumSolsModel;
	}

	public void onRowSelect(SelectEvent event) {
		System.out.println("TableBean.onRowSelect()");
		System.out.println(event.getObject());
        //FacesMessage msg = new FacesMessage("Sol Selected",((Solicitud) event.getObject()).getIdSolicitud().toString());  
  
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onRowUnselect(UnselectEvent event) {
    	System.out.println("TableBean.onRowUnselect()");
        FacesMessage msg = new FacesMessage("Sol Unselected", ((Solicitud) event.getObject()).getIdSolicitud().toString());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	public void AsignarTecnico(){
		
		
//		solserv.getSolicitudById(id);
	}
	
	public void SeleccionaSolicitud(){
		
	}
	
	
}
