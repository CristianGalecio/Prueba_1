package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_UBICACION")
	private int idUbicacion;

	@Column(name="NOMBRE_UBICACION")
	private String nombreUbicacion;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="ubicacionBean")
	private List<Solicitud> solicituds;

	public Ubicacion() {
	}

	public int getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombreUbicacion() {
		return this.nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setUbicacionBean(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setUbicacionBean(null);

		return solicitud;
	}

}