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
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EVALUACION")
    private Integer idEvaluacion;
    @Basic(optional = false)
    @Column(name = "VALOR_EVALUACION")
    private int valorEvaluacion;
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

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Evaluacion(Integer idEvaluacion, int valorEvaluacion, String obsEvaluacion, Date fechaEvaluacion, Date horaEvaluacion) {
        this.idEvaluacion = idEvaluacion;
        this.valorEvaluacion = valorEvaluacion;
        this.obsEvaluacion = obsEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
        this.horaEvaluacion = horaEvaluacion;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getValorEvaluacion() {
        return valorEvaluacion;
    }

    public void setValorEvaluacion(int valorEvaluacion) {
        this.valorEvaluacion = valorEvaluacion;
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
        return "com.proyecto.siswebastec.model.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
