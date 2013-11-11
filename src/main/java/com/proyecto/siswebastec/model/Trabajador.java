package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trabajador database table.
 * 
 */
@Entity
@NamedQuery(name="Trabajador.findAll", query="SELECT t FROM Trabajador t")
public class Trabajador implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrabajadorPK id;

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

	@Column(name="ESTADO_TRABAJADOR")
	private byte estadoTrabajador;

	@Column(name="ID_PERFIL")
	private int idPerfil;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="trabajador")
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Turno
	@OneToMany(mappedBy="trabajador")
	private List<Turno> turnos;

	public Trabajador() {
	}

	public TrabajadorPK getId() {
		return this.id;
	}

	public void setId(TrabajadorPK id) {
		this.id = id;
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

	public byte getEstadoTrabajador() {
		return this.estadoTrabajador;
	}

	public void setEstadoTrabajador(byte estadoTrabajador) {
		this.estadoTrabajador = estadoTrabajador;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setTrabajador(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setTrabajador(null);

		return atencion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Turno> getTurnos() {
		return this.turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Turno addTurno(Turno turno) {
		getTurnos().add(turno);
		turno.setTrabajador(this);

		return turno;
	}

	public Turno removeTurno(Turno turno) {
		getTurnos().remove(turno);
		turno.setTrabajador(null);

		return turno;
	}

}