package com.proyecto.siswebastec.services;

import java.util.List;

import com.proyecto.siswebastec.model.Trabajador;

public interface TrabajadorService {
	
	public void addTrabajador(Trabajador trabajador);	
	public void updateTrabajador(Trabajador trabajador);
	public void deleteTrabajador(Trabajador rabajador);	
	public Trabajador getTrabajadorById(String id);	
	public List<Trabajador> getTrabajadores();	
	public Boolean verificarTrabajador(String id, String password);

}
