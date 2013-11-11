package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientePK id;

	@Column(name="ANEXO_CLIENTE")
	private int anexoCliente;

	@Column(name="APMAT_USUARIO")
	private String apmatUsuario;

	@Column(name="APPAT_USUARIO")
	private String appatUsuario;

	@Column(name="CARGO_CLIENTE")
	private String cargoCliente;

	@Column(name="CELULAR_USUARIO")
	private int celularUsuario;

	@Column(name="CLAVE_USUARIO")
	private String claveUsuario;

	@Column(name="DNI_USUARIO")
	private String dniUsuario;

	@Column(name="EMAIL_USUARIO")
	private String emailUsuario;

	@Column(name="ID_PERFIL")
	private int idPerfil;

	@Column(name="NOMBRE_USUARIO")
	private String nombreUsuario;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="ID_AREA")
	private Area area;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Solicitud
	@OneToMany(mappedBy="cliente")
	private List<Solicitud> solicituds;

	public Cliente() {
	}

	public ClientePK getId() {
		return this.id;
	}

	public void setId(ClientePK id) {
		this.id = id;
	}

	public int getAnexoCliente() {
		return this.anexoCliente;
	}

	public void setAnexoCliente(int anexoCliente) {
		this.anexoCliente = anexoCliente;
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

	public String getCargoCliente() {
		return this.cargoCliente;
	}

	public void setCargoCliente(String cargoCliente) {
		this.cargoCliente = cargoCliente;
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

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Solicitud> getSolicituds() {
		return this.solicituds;
	}

	public void setSolicituds(List<Solicitud> solicituds) {
		this.solicituds = solicituds;
	}

	public Solicitud addSolicitud(Solicitud solicitud) {
		getSolicituds().add(solicitud);
		solicitud.setCliente(this);

		return solicitud;
	}

	public Solicitud removeSolicitud(Solicitud solicitud) {
		getSolicituds().remove(solicitud);
		solicitud.setCliente(null);

		return solicitud;
	}

}