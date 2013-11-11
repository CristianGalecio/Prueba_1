package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	private int idPerfil;

	@Column(name="DESC_PERFIL")
	private String descPerfil;

	@Column(name="NOMBRE_PERFIL")
	private String nombrePerfil;

	//bi-directional many-to-many association to Privilegio
	@ManyToMany(mappedBy="perfils")
	private List<Privilegio> privilegios;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescPerfil() {
		return this.descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

	public String getNombrePerfil() {
		return this.nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public List<Privilegio> getPrivilegios() {
		return this.privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}