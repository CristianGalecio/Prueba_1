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
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByObsEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.obsEvaluacion = :obsEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByFechaEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.fechaEvaluacion = :fechaEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByHoraEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.horaEvaluacion = :horaEvaluacion")})
	
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVALUACION")
    private Integer idEvaluacion;
    @Basic(optional = false)
    @Column(name = "OBS_EVALUACION")
    private String obsEvaluacion;
    @Basic(optional = false)
    @Column(name = "FECHA_EVALUACION")
    @Temporal(TemporalType.DATE)
    private Date fechaEvaluacion;
    @Basic(optional = false)
    @Column(name = "HORA_EVALUACION")
    @Temporal(TemporalType.TIME)
    private Date horaEvaluacion;
    @OneToMany(mappedBy = "idEvaluacion")
    private List<Atencion> atencionList;
    @JoinColumn(name = "VALOR_EVALUACION", referencedColumnName = "ID_CALIFICACION")
    @ManyToOne(optional = false)
    private Calificacion valorEvaluacion;
    @JoinColumn(name = "ID_ATENCION", referencedColumnName = "ID_ATENCION")
    @ManyToOne(optional = false)
    private Atencion idAtencion;

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Evaluacion(Integer idEvaluacion, String obsEvaluacion, Date fechaEvaluacion, Date horaEvaluacion) {
        this.idEvaluacion = idEvaluacion;
        this.obsEvaluacion = obsEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
        this.horaEvaluacion = horaEvaluacion;
    }
    
    public Evaluacion(String obsEvaluacion, Date fechaEvaluacion, Date horaEvaluacion,Atencion aten,Calificacion cal) {
        //this.idEvaluacion = idEvaluacion;
        this.obsEvaluacion = obsEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
        this.horaEvaluacion = horaEvaluacion;
        this.idAtencion=aten;
        this.valorEvaluacion=cal;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getObsEvaluacion() {
        return obsEvaluacion;
    }

    public void setObsEvaluacion(String obsEvaluacion) {
        this.obsEvaluacion = obsEvaluacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Date getHoraEvaluacion() {
        return horaEvaluacion;
    }

    public void setHoraEvaluacion(Date horaEvaluacion) {
        this.horaEvaluacion = horaEvaluacion;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    public Calificacion getValorEvaluacion() {
        return valorEvaluacion;
    }

    public void setValorEvaluacion(Calificacion valorEvaluacion) {
        this.valorEvaluacion = valorEvaluacion;
    }

    public Atencion getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(Atencion idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prueba_1.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
