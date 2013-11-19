package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.services.PrioridadService;
import com.proyecto.siswebastec.servicesImpl.PrioridadServiceImpl;

public class ButtonBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String btn = "ALTA";      
//    private List<Prioridad> prioridades;  
    private List<String>	prinames;
    private PrioridadService prioridadService;
    
    public ButtonBean() { 
    	prioridadService = new PrioridadServiceImpl();
  //  	prioridades = new ArrayList<>();
  //  	prioridades = prioridadService.getPrioridades();
    	prinames = new ArrayList<>();
    	prinames = prioridadService.getNombresPri();
    }

	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public List<String> getPrinames() {
		return prinames;
	}

	public void setPrioridades(List<String> prinames) {
		this.prinames = prinames;
	}
    
    
}
