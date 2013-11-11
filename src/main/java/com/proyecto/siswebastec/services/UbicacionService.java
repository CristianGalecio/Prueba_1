package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Area;
import com.proyecto.siswebastec.model.Aula;
import com.proyecto.siswebastec.model.Laboratorio;
import com.proyecto.siswebastec.model.Ubicacion;


public interface UbicacionService {

	public void addUbicacion(Ubicacion ubicacion);	
	public void updateUbicacion(Ubicacion ubicacion);
	public void deleteUbicacion(Ubicacion ubicacion);	
	public Ubicacion getUbicacionById(int id);	
	public List<Ubicacion> getUbicaciones();
	public List<String> getNombreUbi();
	public List<Area> getAreas();
	public List<String> getNombreAreas();
	public List<Aula> getAulas();
	public List<String> getNombreAulas();
	public List<Laboratorio> getLabos();
	public List<String> getNombreLabos();
	
}
