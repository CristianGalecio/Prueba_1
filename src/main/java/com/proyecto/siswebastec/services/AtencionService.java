package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Atencion;

public interface AtencionService {
	
	public void addAtencion(Atencion atencion);	
	public void updateAtencion(Atencion atencion);
	public void deleteAtencion(Atencion atencion);	
	public Atencion getAtencionById(String id);	
	public List<Atencion> getAtenciones();

}
