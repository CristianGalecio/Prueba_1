package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the atencion database table.
 * 
 */
@Entity
@NamedQuery(name="Atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ATENCION")
	private int idAtencion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ATENCION")
	private Date fechaAtencion;

	@Column(name="HORA_ATENCION")
	private Time horaAtencion;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	@JoinColumn(name="ID_EVALUACION")
	private Evaluacion evaluacion;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private Solicitud solicitud;

	//bi-directional many-to-one association to Trabajador
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_TRABAJADOR", referencedColumnName="ID_TRABAJADOR"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Trabajador trabajador;

	public Atencion() {
	}

	public int getIdAtencion() {
		return this.idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
	}

	public Date getFechaAtencion() {
		return this.fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Time getHoraAtencion() {
		return this.horaAtencion;
	}

	public void setHoraAtencion(Time horaAtencion) {
		this.horaAtencion = horaAtencion;
	}

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

}