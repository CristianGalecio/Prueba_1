package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the trabajador database table.
 * 
 */
@Embeddable
public class TrabajadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="ID_TRABAJADOR")
	private String idTrabajador;

	public TrabajadorPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdTrabajador() {
		return this.idTrabajador;
	}
	public void setIdTrabajador(String idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrabajadorPK)) {
			return false;
		}
		TrabajadorPK castOther = (TrabajadorPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.idTrabajador.equals(castOther.idTrabajador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idTrabajador.hashCode();
		
		return hash;
	}
}