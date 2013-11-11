package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cliente database table.
 * 
 */
@Embeddable
public class ClientePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USUARIO", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="ID_CLIENTE")
	private String idCliente;

	public ClientePK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClientePK)) {
			return false;
		}
		ClientePK castOther = (ClientePK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.idCliente.equals(castOther.idCliente);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idCliente.hashCode();
		
		return hash;
	}
}