package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.services.PrioridadService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.servicesImpl.PrioridadServiceImpl;
import com.proyecto.siswebastec.servicesImpl.TrabajadorServiceImpl;

public class ButtonBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String prioridad = "Seleccione";
	private String trabajador = "Seleccione";
//    private List<Prioridad> prioridades;  
    private List<String> prinames;
    private List<String> traid;
    private PrioridadService prioridadService;
    private TrabajadorService trabajadorService; 
    
    public ButtonBean() { 
    	prioridadService = new PrioridadServiceImpl();
    	trabajadorService = new TrabajadorServiceImpl();
  //  	prioridades = new ArrayList<>();
  //  	prioridades = prioridadService.getPrioridades();
    	prinames = new ArrayList<>();
    	traid = new ArrayList<>();
    	prinames = prioridadService.getNombresPri();
    	traid = trabajadorService.getIdTrabajadores();
    }

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public List<String> getPrinames() {
		return prinames;
	}

	public void setPrioridades(List<String> prinames) {
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
    
    
}
