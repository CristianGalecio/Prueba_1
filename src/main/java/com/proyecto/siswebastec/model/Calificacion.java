package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c")
public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CALIFICACION")
	private int idCalificacion;

	@Column(name="NOMBRE_CALIFICACION")
	private String nombreCalificacion;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="calificacion")
	private List<Evaluacion> evaluacions;

	public Calificacion() {
	}

	public int getIdCalificacion() {
		return this.idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public String getNombreCalificacion() {
		return this.nombreCalificacion;
	}

	public void setNombreCalificacion(String nombreCalificacion) {
		this.nombreCalificacion = nombreCalificacion;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setCalificacion(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setCalificacion(null);

		return evaluacion;
	}

}