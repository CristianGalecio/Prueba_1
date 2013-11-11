package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the privilegio database table.
 * 
 */
@Entity
@NamedQuery(name="Privilegio.findAll", query="SELECT p FROM Privilegio p")
public class Privilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRIVILEGIO")
	private int idPrivilegio;

	@Column(name="NOMBRE_PRIVILEGIO")
	private String nombrePrivilegio;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="pf_pri"
		, joinColumns={
			@JoinColumn(name="ID_PRIVILEGIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PERFIL")
			}
		)
	private List<Perfil> perfils;

	public Privilegio() {
	}

	public int getIdPrivilegio() {
		return this.idPrivilegio;
	}

	public void setIdPrivilegio(int idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public String getNombrePrivilegio() {
		return this.nombrePrivilegio;
	}

	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

}