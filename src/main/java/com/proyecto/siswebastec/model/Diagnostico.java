package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnostico.findAll", query="SELECT d FROM Diagnostico d")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DIAGNOSTICO")
	private int idDiagnostico;

	@Column(name="DET_DIAGNOSTICO")
	private String detDiagnostico;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DIAGNOSTICO")
	private Date fechaDiagnostico;

	//bi-directional many-to-one association to Solicitud
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private Solicitud solicitud;

	public Diagnostico() {
	}

	public int getIdDiagnostico() {
		return this.idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getDetDiagnostico() {
		return this.detDiagnostico;
	}

	public void setDetDiagnostico(String detDiagnostico) {
		this.detDiagnostico = detDiagnostico;
	}

	public Date getFechaDiagnostico() {
		return this.fechaDiagnostico;
	}

	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}

	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

}