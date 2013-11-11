package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the solucion database table.
 * 
 */
@Entity
@NamedQuery(name="Solucion.findAll", query="SELECT s FROM Solucion s")
public class Solucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SOLUCION")
	private int idSolucion;

	@Column(name="DESC_SOLUCION")
	private String descSolucion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SOLUCION")
	private Date fechaSolucion;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private Solicitud solicitud;

	public Solucion() {
	}

	public int getIdSolucion() {
		return this.idSolucion;
	}

	public void setIdSolucion(int idSolucion) {
		this.idSolucion = idSolucion;
	}

	public String getDescSolucion() {
		return this.descSolucion;
	}

	public void setDescSolucion(String descSolucion) {
		this.descSolucion = descSolucion;
	}

	public Date getFechaSolucion() {
		return this.fechaSolucion;
	}

	public void setFechaSolucion(Date fechaSolucion) {
		this.fechaSolucion = fechaSolucion;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}