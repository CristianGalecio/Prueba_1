package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Solicitud;

public interface SolicitudService {
	
	public void addSolicitud(Solicitud solicitud);	
	public void updateSolicitud(Solicitud solicitud);
	public void deleteSolicitud(Solicitud solicitud);	
	public Solicitud getSolicitudById(String id);	
	public List<Solicitud> getSolicitudes();
	public boolean verificaSolicitud(int id);

}
