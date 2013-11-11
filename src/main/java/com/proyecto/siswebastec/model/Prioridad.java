package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prioridad database table.
 * 
 */
@Entity
@NamedQuery(name="Prioridad.findAll", query="SELECT p FROM Prioridad p")
public class Prioridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRIORIDAD")
	private int idPrioridad;

	@Column(name="NOMBRE_PRIORIDAD")
	private String nombrePrioridad;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="prioridad")
	private List<Solicitud> solicituds;

	public Prioridad() {
	}

	public int getIdPrioridad() {
		return this.idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getNombrePrioridad() {
		return this.nombrePrioridad;
	}

	public void setNombrePrioridad(String nombrePrioridad) {
		this.nombrePrioridad = nombrePrioridad;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setPrioridad(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setPrioridad(null);

		return solicitud;
	}

}