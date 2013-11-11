package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aula database table.
 * 
 */
@Entity
@NamedQuery(name="Aula.findAll", query="SELECT a FROM Aula a")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AULA")
	private int idAula;

	@Column(name="NUMERO_AULA")
	private String numeroAula;

	public Aula() {
	}

	public int getIdAula() {
		return this.idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getNumeroAula() {
		return this.numeroAula;
	}

	public void setNumeroAula(String numeroAula) {
		this.numeroAula = numeroAula;
	}

}