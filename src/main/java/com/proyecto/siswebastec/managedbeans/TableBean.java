package com.proyecto.siswebastec.managedbeans;

import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.model.Solicitud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableBean implements Serializable{
	List<Solicitud> solicitudes;
	SolicitudService solserv;
	public TableBean(){
		solicitudes=new ArrayList<Solicitud>();
		solserv=new SolicitudServiceImpl();
		solicitudes=solserv.getSolicitudes();
		System.out.println("Holitas!");
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
	
	
	
}
