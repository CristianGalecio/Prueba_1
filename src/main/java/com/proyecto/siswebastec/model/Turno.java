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
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TURNO")
    private Integer idTurno;
    @Basic(optional = false)
    @Column(name = "TIPO_TURNO")
    private String tipoTurno;
    @Basic(optional = false)
    @Column(name = "HINICIO_TURNO")
    @Temporal(TemporalType.TIME)
    private Date hinicioTurno;
    @Basic(optional = false)
    @Column(name = "HFIN_TURNO")
    @Temporal(TemporalType.TIME)
    private Date hfinTurno;
    @JoinColumns({
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO"),
        @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID_TRABAJADOR")})
    @ManyToOne(optional = false)
    private Trabajador trabajador;

    public Turno() {
    }

    public Turno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Turno(Integer idTurno, String tipoTurno, Date hinicioTurno, Date hfinTurno) {
        this.idTurno = idTurno;
        this.tipoTurno = tipoTurno;
        this.hinicioTurno = hinicioTurno;
        this.hfinTurno = hfinTurno;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public Date getHinicioTurno() {
        return hinicioTurno;
    }

    public void setHinicioTurno(Date hinicioTurno) {
        this.hinicioTurno = hinicioTurno;
    }

    public Date getHfinTurno() {
        return hfinTurno;
    }

    public void setHfinTurno(Date hfinTurno) {
        this.hfinTurno = hfinTurno;
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
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Turno[ idTurno=" + idTurno + " ]";
    }
    
}
