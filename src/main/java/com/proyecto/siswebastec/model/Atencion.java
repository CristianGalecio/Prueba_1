/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.siswebastec.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johana
 */
@Entity
@Table(name = "atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a")})
public class Atencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ATENCION")
    private Integer idAtencion;
    @Basic(optional = false)
    @Column(name = "FECHA_ATENCION")
    @Temporal(TemporalType.DATE)
    private Date fechaAtencion;
    @Basic(optional = false)
    @Column(name = "HORA_ATENCION")
    @Temporal(TemporalType.TIME)
    private Date horaAtencion;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;
    @JoinColumn(name = "ID_EVALUACION", referencedColumnName = "ID_EVALUACION")
    @ManyToOne
    private Evaluacion idEvaluacion;
    @JoinColumns({
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"),
        @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID_TRABAJADOR")})
    @ManyToOne
    private Trabajador trabajador;

    public Atencion() {
    }

    public Atencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Atencion(Integer idAtencion, Date fechaAtencion, Date horaAtencion) {
        this.idAtencion = idAtencion;
        this.fechaAtencion = fechaAtencion;
        this.horaAtencion = horaAtencion;
    }

    public Integer getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Date getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(Date horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Evaluacion getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Evaluacion idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtencion != null ? idAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.idAtencion == null && other.idAtencion != null) || (this.idAtencion != null && !this.idAtencion.equals(other.idAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Atencion[ idAtencion=" + idAtencion + " ]";
    }
    
}
