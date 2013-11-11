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
@Table(name = "solucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solucion.findAll", query = "SELECT s FROM Solucion s")})
public class Solucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLUCION")
    private Integer idSolucion;
    @Basic(optional = false)
    @Column(name = "DESC_SOLUCION")
    private String descSolucion;
    @Basic(optional = false)
    @Column(name = "FECHA_SOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;

    public Solucion() {
    }

    public Solucion(Integer idSolucion) {
        this.idSolucion = idSolucion;
    }

    public Solucion(Integer idSolucion, String descSolucion, Date fechaSolucion) {
        this.idSolucion = idSolucion;
        this.descSolucion = descSolucion;
        this.fechaSolucion = fechaSolucion;
    }

    public Integer getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(Integer idSolucion) {
        this.idSolucion = idSolucion;
    }

    public String getDescSolucion() {
        return descSolucion;
    }

    public void setDescSolucion(String descSolucion) {
        this.descSolucion = descSolucion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolucion != null ? idSolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solucion)) {
            return false;
        }
        Solucion other = (Solucion) object;
        if ((this.idSolucion == null && other.idSolucion != null) || (this.idSolucion != null && !this.idSolucion.equals(other.idSolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Solucion[ idSolucion=" + idSolucion + " ]";
    }
    
}
