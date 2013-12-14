package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Diagnostico;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Solucion;

public interface SolicitudService {
	
	public void addSolicitud(Solicitud solicitud);	
	public void updateSolicitud(Solicitud solicitud);
	public void deleteSolicitud(Solicitud solicitud);	
	public Solicitud getSolicitudById(int id);	
	public List<Solicitud> getSolicitudes();
	public boolean verificaSolicitud(int id);
	public List<Solicitud> getSolicitudesPendientes();
	public List<Solicitud> getSolicitudesProceso();
	public List<Solicitud> getSolicitudesFinalizadas();
	public List<Solicitud> getSolicitudesProcesoPendientes();
	public void addDiagnostico(Diagnostico diag);
	public void addSolucion(Solucion sol);
	public List<String> getListaCat();
	public void actualizarCat(Solicitud sasig);
	public List<String> getListaDiagnosticos(int id);
	public void updateDiagnostico(Diagnostico diagnostico);
	public Diagnostico getDiagnosticoById(int id);

}
