package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TURNO")
	private int idTurno;

	@Column(name="HFIN_TURNO")
	private Time hfinTurno;

	@Column(name="HINICIO_TURNO")
	private Time hinicioTurno;

	@Column(name="TIPO_TURNO")
	private String tipoTurno;

	//bi-directional many-to-one association to Trabajador
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_TRABAJADOR", referencedColumnName="ID_TRABAJADOR"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Trabajador trabajador;

	public Turno() {
	}

	public int getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public Time getHfinTurno() {
		return this.hfinTurno;
	}

	public void setHfinTurno(Time hfinTurno) {
		this.hfinTurno = hfinTurno;
	}

	public Time getHinicioTurno() {
		return this.hinicioTurno;
	}

	public void setHinicioTurno(Time hinicioTurno) {
		this.hinicioTurno = hinicioTurno;
	}

	public String getTipoTurno() {
		return this.tipoTurno;
	}

	public void setTipoTurno(String tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

}