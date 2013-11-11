package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="APMAT_USUARIO")
	private String apmatUsuario;

	@Column(name="APPAT_USUARIO")
	private String appatUsuario;

	@Column(name="CELULAR_USUARIO")
	private int celularUsuario;

	@Column(name="CLAVE_USUARIO")
	private String claveUsuario;

	@Column(name="DNI_USUARIO")
	private String dniUsuario;

	@Column(name="EMAIL_USUARIO")
	private String emailUsuario;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="usuario")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Trabajador
	@OneToMany(mappedBy="usuario")
	private List<Trabajador> trabajadors;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	private Perfil perfil;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApmatUsuario() {
		return this.apmatUsuario;
	}

	public void setApmatUsuario(String apmatUsuario) {
		this.apmatUsuario = apmatUsuario;
	}

	public String getAppatUsuario() {
		return this.appatUsuario;
	}

	public void setAppatUsuario(String appatUsuario) {
		this.appatUsuario = appatUsuario;
	}

	public int getCelularUsuario() {
		return this.celularUsuario;
	}

	public void setCelularUsuario(int celularUsuario) {
		this.celularUsuario = celularUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getDniUsuario() {
		return this.dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setUsuario(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setUsuario(null);

		return cliente;
	}

	public List<Trabajador> getTrabajadors() {
		return this.trabajadors;
	}

	public void setTrabajadors(List<Trabajador> trabajadors) {
		this.trabajadors = trabajadors;
	}

	public Trabajador addTrabajador(Trabajador trabajador) {
		getTrabajadors().add(trabajador);
		trabajador.setUsuario(this);

		return trabajador;
	}

	public Trabajador removeTrabajador(Trabajador trabajador) {
		getTrabajadors().remove(trabajador);
		trabajador.setUsuario(null);

		return trabajador;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}