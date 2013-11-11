package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitud database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitud.findAll", query="SELECT s FROM Solicitud s")
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SOLICITUD")
	private int idSolicitud;

	@Column(name="DESC_SOLICITUD")
	private String descSolicitud;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CIERRE")
	private Date fechaCierre;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INGRESO")
	private Date fechaIngreso;

	@Column(name="HORA_CIERRE")
	private Time horaCierre;

	@Column(name="HORA_INGRESO")
	private Time horaIngreso;

	private String ubicacion;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="solicitud")
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="solicitud")
	private List<Diagnostico> diagnosticos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria categoria;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_CLIENTE", referencedColumnName="ID_CLIENTE"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Cliente cliente;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	//bi-directional many-to-one association to Prioridad
	@ManyToOne
	@JoinColumn(name="ID_PRIORIDAD")
	private Prioridad prioridad;

	//bi-directional many-to-one association to TipoSolicitud
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private TipoSolicitud tipoSolicitud;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name="ID_UBICACION")
	private Ubicacion ubicacionBean;

	//bi-directional many-to-one association to Solucion
	@OneToMany(mappedBy="solicitud")
	private List<Solucion> solucions;

	public Solicitud() {
	}

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getDescSolicitud() {
		return this.descSolicitud;
	}

	public void setDescSolicitud(String descSolicitud) {
		this.descSolicitud = descSolicitud;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Time getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(Time horaCierre) {
		this.horaCierre = horaCierre;
	}

	public Time getHoraIngreso() {
		return this.horaIngreso;
	}

	public void setHoraIngreso(Time horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setSolicitud(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setSolicitud(null);

		return atencion;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public Diagnostico addDiagnostico(Diagnostico diagnostico) {
		getDiagnosticos().add(diagnostico);
		diagnostico.setSolicitud(this);

		return diagnostico;
	}

	public Diagnostico removeDiagnostico(Diagnostico diagnostico) {
		getDiagnosticos().remove(diagnostico);
		diagnostico.setSolicitud(null);

		return diagnostico;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Prioridad getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public TipoSolicitud getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Ubicacion getUbicacionBean() {
		return this.ubicacionBean;
	}

	public void setUbicacionBean(Ubicacion ubicacionBean) {
		this.ubicacionBean = ubicacionBean;
	}

	public List<Solucion> getSolucions() {
		return this.solucions;
	}

	public void setSolucions(List<Solucion> solucions) {
		this.solucions = solucions;
	}

	public Solucion addSolucion(Solucion solucion) {
		getSolucions().add(solucion);
		solucion.setSolicitud(this);

		return solucion;
	}

	public Solucion removeSolucion(Solucion solucion) {
		getSolucions().remove(solucion);
		solucion.setSolicitud(null);

		return solucion;
	}

}