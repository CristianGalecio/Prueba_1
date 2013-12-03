/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.siswebastec.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johana
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByIdUsuario", query = "SELECT t FROM Trabajador t WHERE t.trabajadorPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Trabajador.findByNombreUsuario", query = "SELECT t FROM Trabajador t WHERE t.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Trabajador.findByAppatUsuario", query = "SELECT t FROM Trabajador t WHERE t.appatUsuario = :appatUsuario"),
    @NamedQuery(name = "Trabajador.findByApmatUsuario", query = "SELECT t FROM Trabajador t WHERE t.apmatUsuario = :apmatUsuario"),
    @NamedQuery(name = "Trabajador.findByDniUsuario", query = "SELECT t FROM Trabajador t WHERE t.dniUsuario = :dniUsuario"),
    @NamedQuery(name = "Trabajador.findByEmailUsuario", query = "SELECT t FROM Trabajador t WHERE t.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "Trabajador.findByClaveUsuario", query = "SELECT t FROM Trabajador t WHERE t.claveUsuario = :claveUsuario"),
    @NamedQuery(name = "Trabajador.findByCelularUsuario", query = "SELECT t FROM Trabajador t WHERE t.celularUsuario = :celularUsuario"),
    @NamedQuery(name = "Trabajador.findByEstadoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.estadoTrabajador = :estadoTrabajador"),
    @NamedQuery(name = "Trabajador.findByIdTrabajador", query = "SELECT t FROM Trabajador t WHERE t.trabajadorPK.idTrabajador = :idTrabajador")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabajadorPK trabajadorPK;
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Column(name = "APPAT_USUARIO")
    private String appatUsuario;
    @Column(name = "APMAT_USUARIO")
    private String apmatUsuario;
    @Column(name = "DNI_USUARIO")
    private String dniUsuario;
    @Column(name = "EMAIL_USUARIO")
    private String emailUsuario;
    @Column(name = "CLAVE_USUARIO")
    private String claveUsuario;
    @Column(name = "CELULAR_USUARIO")
    private Integer celularUsuario;
    @Basic(optional = false)
    @Column(name = "ESTADO_TRABAJADOR")
    private boolean estadoTrabajador;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private List<Turno> turnoList;
    @OneToMany(mappedBy = "trabajador")
    private List<Atencion> atencionList;

    public Trabajador() {
    }

    public Trabajador(TrabajadorPK trabajadorPK) {
        this.trabajadorPK = trabajadorPK;
    }

    public Trabajador(TrabajadorPK trabajadorPK, boolean estadoTrabajador) {
        this.trabajadorPK = trabajadorPK;
        this.estadoTrabajador = estadoTrabajador;
    }

    public Trabajador(int idUsuario, String idTrabajador) {
        this.trabajadorPK = new TrabajadorPK(idUsuario, idTrabajador);
    }

    public TrabajadorPK getTrabajadorPK() {
        return trabajadorPK;
    }

    public void setTrabajadorPK(TrabajadorPK trabajadorPK) {
        this.trabajadorPK = trabajadorPK;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getAppatUsuario() {
        return appatUsuario;
    }

    public void setAppatUsuario(String appatUsuario) {
        this.appatUsuario = appatUsuario;
    }

    public String getApmatUsuario() {
        return apmatUsuario;
    }

    public void setApmatUsuario(String apmatUsuario) {
        this.apmatUsuario = apmatUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public Integer getCelularUsuario() {
        return celularUsuario;
    }

    public void setCelularUsuario(Integer celularUsuario) {
        this.celularUsuario = celularUsuario;
    }

    public boolean getEstadoTrabajador() {
        return estadoTrabajador;
    }

    public void setEstadoTrabajador(boolean estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
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
        hash += (trabajadorPK != null ? trabajadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.trabajadorPK == null && other.trabajadorPK != null) || (this.trabajadorPK != null && !this.trabajadorPK.equals(other.trabajadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Trabajador[ trabajadorPK=" + trabajadorPK + " ]";
    }
    
}
