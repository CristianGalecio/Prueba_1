package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EVALUACION")
	private int idEvaluacion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_EVALUACION")
	private Date fechaEvaluacion;

	@Column(name="HORA_EVALUACION")
	private Time horaEvaluacion;

	@Column(name="OBS_EVALUACION")
	private String obsEvaluacion;

	//bi-directional many-to-one association to Calificacion
	@ManyToOne
	@JoinColumn(name="VALOR_EVALUACION")
	private Calificacion calificacion;

	public Evaluacion() {
	}

	public int getIdEvaluacion() {
		return this.idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Date getFechaEvaluacion() {
		return this.fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Time getHoraEvaluacion() {
		return this.horaEvaluacion;
	}

	public void setHoraEvaluacion(Time horaEvaluacion) {
		this.horaEvaluacion = horaEvaluacion;
	}

	public String getObsEvaluacion() {
		return this.obsEvaluacion;
	}

	public void setObsEvaluacion(String obsEvaluacion) {
		this.obsEvaluacion = obsEvaluacion;
	}

	public Calificacion getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

}