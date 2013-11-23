package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;	
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;



import com.proyecto.siswebastec.DAO.EvaluacionDAO;
import com.proyecto.siswebastec.model.Evaluacion;
import com.proyecto.siswebastec.services.AtencionService;
import com.proyecto.siswebastec.servicesImpl.AtencionServiceImpl;

public class EvaluacionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String calificacion;
	
	private AtencionService ate;
	private List<String> calificaciones;
	private String observacion;
	
	public EvaluacionBean(){
		ate=new AtencionServiceImpl();
		calificaciones=ate.getCalificacionesNombre();
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public List<String> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<String> calificaciones) {
		this.calificaciones = calificaciones;
	}

	
	public void grabar(ActionEvent a){
		System.out.println("EvaluacionBean.grabar()");
		Evaluacion eval=new Evaluacion();
		String calif=getCalificacion();
		Date Fecha = Calendar.getInstance().getTime();
		
		eval.setFechaEvaluacion(Fecha);
		eval.setHoraEvaluacion(Fecha);
		eval.setObsEvaluacion(getObservacion());
		eval.setValorEvaluacion(ate.getCalificacionporNombre(calif));
		
		ate.addEvaluacion(eval);
	}
	
}
