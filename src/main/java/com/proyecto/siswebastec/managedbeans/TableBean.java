package com.proyecto.siswebastec.managedbeans;

import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.model.Solicitud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableBean implements Serializable{
	List<Solicitud> solicitudes,solicitudespend,solicitudespro,solicitudesfin;
	SolicitudService solserv;
	public TableBean(){
		solicitudes=new ArrayList<Solicitud>();
		solserv=new SolicitudServiceImpl();
		//solicitudes=solserv.getSolicitudes();
		
//		System.out.println("Holitas!");
	}
	
	public List<Solicitud> getSolicitudespend() {
		setSolicitudespend(solserv.getSolicitudesPendientes());
		return solicitudespend;
	}

	public void setSolicitudespend(List<Solicitud> solicitudespend) {
		this.solicitudespend = solicitudespend;
	}

	public List<Solicitud> getSolicitudespro() {
		return solicitudespro;
	}

	public void setSolicitudespro(List<Solicitud> solicitudespro) {
		this.solicitudespro = solicitudespro;
	}

	public List<Solicitud> getSolicitudesfin() {
		return solicitudesfin;
	}

	public void setSolicitudesfin(List<Solicitud> solicitudesfin) {
		this.solicitudesfin = solicitudesfin;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public SolicitudService getSolserv() {
		return solserv;
	}
	
	public void setSolserv(SolicitudService solserv) {
		this.solserv = solserv;
	}
	
	public void AsignarTecnico(){
		
		
//		solserv.getSolicitudById(id);
	}
	
	public void SeleccionaSolicitud(){
		
	}
	
	
}
