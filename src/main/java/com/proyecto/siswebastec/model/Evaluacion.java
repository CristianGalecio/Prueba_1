package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


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

	@Column(name="VALOR_EVALUACION")
	private int valorEvaluacion;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="evaluacion")
	private List<Atencion> atencions;

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

	public int getValorEvaluacion() {
		return this.valorEvaluacion;
	}

	public void setValorEvaluacion(int valorEvaluacion) {
		this.valorEvaluacion = valorEvaluacion;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setEvaluacion(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setEvaluacion(null);

		return atencion;
	}

}