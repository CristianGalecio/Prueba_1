/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.siswebastec.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author johana
 */
@Embeddable
public class TrabajadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic(optional = false)
    @Column(name = "ID_TRABAJADOR")
    private String idTrabajador;

    public TrabajadorPK() {
    }

    public TrabajadorPK(int idUsuario, String idTrabajador) {
        this.idUsuario = idUsuario;
        this.idTrabajador = idTrabajador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorPK)) {
            return false;
        }
        TrabajadorPK other = (TrabajadorPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.TrabajadorPK[ idUsuario=" + idUsuario + ", idTrabajador=" + idTrabajador + " ]";
    }
    
}
