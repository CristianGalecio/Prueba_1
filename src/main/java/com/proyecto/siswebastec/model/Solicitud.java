/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.siswebastec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johana
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByIdSolicitante", query = "SELECT s FROM Solicitud s WHERE s.idSolicitante = :idSolicitante"),
    @NamedQuery(name = "Solicitud.findByDescSolicitud", query = "SELECT s FROM Solicitud s WHERE s.descSolicitud = :descSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaIngreso", query = "SELECT s FROM Solicitud s WHERE s.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Solicitud.findByFechaCierre", query = "SELECT s FROM Solicitud s WHERE s.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "Solicitud.findByHoraIngreso", query = "SELECT s FROM Solicitud s WHERE s.horaIngreso = :horaIngreso"),
    @NamedQuery(name = "Solicitud.findByHoraCierre", query = "SELECT s FROM Solicitud s WHERE s.horaCierre = :horaCierre"),
    @NamedQuery(name = "Solicitud.findByUbicacion", query = "SELECT s FROM Solicitud s WHERE s.ubicacion = :ubicacion")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITUD")
    private Integer idSolicitud;
    @Basic(optional = false)
    @Column(name = "ID_SOLICITANTE")
    private String idSolicitante;
    @Basic(optional = false)
    @Column(name = "DESC_SOLICITUD")
    private String descSolicitud;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @Column(name = "HORA_INGRESO")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Basic(optional = false)
    @Column(name = "HORA_CIERRE")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @Basic(optional = false)
    @Column(name = "UBICACION")
    private String ubicacion;
    @JoinColumn(name = "ID_UBICACION", referencedColumnName = "ID_UBICACION")
    @ManyToOne(optional = false)
    private Ubicacion idUbicacion;
    @JoinColumn(name = "ID_TIPO", referencedColumnName = "ID_TIPO")
    @ManyToOne(optional = false)
    private TipoSolicitud idTipo;
    @JoinColumn(name = "ID_PRIORIDAD", referencedColumnName = "ID_PRIORIDAD")
    @ManyToOne
    private Prioridad idPrioridad;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumns({
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"),
        @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")})
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria idCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
    private List<Atencion> atencionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
    private List<Diagnostico> diagnosticoList;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, String idSolicitante, String descSolicitud, Date fechaIngreso, Date fechaCierre, Date horaIngreso, Date horaCierre, String ubicacion) {
        this.idSolicitud = idSolicitud;
        this.idSolicitante = idSolicitante;
        this.descSolicitud = descSolicitud;
        this.fechaIngreso = fechaIngreso;
        this.fechaCierre = fechaCierre;
        this.horaIngreso = horaIngreso;
        this.horaCierre = horaCierre;
        this.ubicacion = ubicacion;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getDescSolicitud() {
        return descSolicitud;
    }

    public void setDescSolicitud(String descSolicitud) {
        this.descSolicitud = descSolicitud;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicacion idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public TipoSolicitud getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoSolicitud idTipo) {
        this.idTipo = idTipo;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
