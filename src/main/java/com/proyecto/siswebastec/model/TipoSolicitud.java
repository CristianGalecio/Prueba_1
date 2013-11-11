package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_solicitud database table.
 * 
 */
@Entity
@Table(name="tipo_solicitud")
@NamedQuery(name="TipoSolicitud.findAll", query="SELECT t FROM TipoSolicitud t")
public class TipoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO")
	private int idTipo;

	@Column(name="NOMBRE_TIPO")
	private String nombreTipo;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="tipoSolicitud")
	private List<Solicitud> solicituds;

	public TipoSolicitud() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setTipoSolicitud(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setTipoSolicitud(null);

		return solicitud;
	}

}