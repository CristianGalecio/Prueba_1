package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Calificacion;
import com.proyecto.siswebastec.model.Evaluacion;

public interface AtencionService {
	
	public void addAtencion(Atencion atencion);	
	public void updateAtencion(Atencion atencion);
	public void deleteAtencion(Atencion atencion);	
	public Atencion getAtencionById(String id);	
	public List<Atencion> getAtenciones();
	public Calificacion getCalificacionById(int id);
	public List<Calificacion> getCalificaciones();
	public List<String> getCalificacionesNombre();
	public Calificacion getCalificacionporNombre(String nombrecalf);
	public void addEvaluacion(Evaluacion evaluacion);
	
	public Atencion getAtencionByIdSol(int idSol);

}
