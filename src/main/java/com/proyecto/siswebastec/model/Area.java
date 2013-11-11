package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AREA")
	private int idArea;

	@Column(name="NOMBRE_AREA")
	private String nombreArea;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="area")
	private List<Cliente> clientes;

	public Area() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return this.nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setArea(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setArea(null);

		return cliente;
	}

}