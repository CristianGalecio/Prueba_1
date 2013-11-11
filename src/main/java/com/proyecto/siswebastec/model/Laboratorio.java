package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the laboratorio database table.
 * 
 */
@Entity
@NamedQuery(name="Laboratorio.findAll", query="SELECT l FROM Laboratorio l")
public class Laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LABORATORIO")
	private int idLaboratorio;

	@Column(name="NOMBRE_LABORATORIO")
	private String nombreLaboratorio;

	public Laboratorio() {
	}

	public int getIdLaboratorio() {
		return this.idLaboratorio;
	}

	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getNombreLaboratorio() {
		return this.nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

}