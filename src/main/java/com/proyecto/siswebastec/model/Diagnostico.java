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
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByIdDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.idDiagnostico = :idDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByNombreDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.nombreDiagnostico = :nombreDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByDescrDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.descrDiagnostico = :descrDiagnostico"),
    @NamedQuery(name = "Diagnostico.findByFechaDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.fechaDiagnostico = :fechaDiagnostico")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIAGNOSTICO")
    private Integer idDiagnostico;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DIAGNOSTICO")
    private String nombreDiagnostico;
    @Basic(optional = false)
    @Column(name = "DESCR_DIAGNOSTICO")
    private String descrDiagnostico;
    @Basic(optional = false)
    @Column(name = "FECHA_DIAGNOSTICO")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @JoinColumn(name = "ID_SOLUCION", referencedColumnName = "ID_SOLUCION")
    @ManyToOne
    private Solucion idSolucion;
    @JoinColumn(name = "ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;

    public Diagnostico() {
    }

    public Diagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Diagnostico(Integer idDiagnostico, String nombreDiagnostico, String descrDiagnostico, Date fechaDiagnostico) {
        this.idDiagnostico = idDiagnostico;
        this.nombreDiagnostico = nombreDiagnostico;
        this.descrDiagnostico = descrDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
    }
    
    public Diagnostico(String nombreDiagnostico, String descrDiagnostico, Date fechaDiagnostico,Solicitud idSolicitud) {
        //this.idDiagnostico = idDiagnostico;
        this.nombreDiagnostico = nombreDiagnostico;
        this.descrDiagnostico = descrDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
        this.idSolicitud=idSolicitud;
    }
    
    public Diagnostico(Solicitud fija, String nombre, String diagnostico, Date time) {
		this.idSolicitud = fija;
		this.nombreDiagnostico = nombre;
		this.descrDiagnostico = diagnostico;
		this.fechaDiagnostico = time;
	}

	public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getDescrDiagnostico() {
        return descrDiagnostico;
    }

    public void setDescrDiagnostico(String descrDiagnostico) {
        this.descrDiagnostico = descrDiagnostico;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public Solucion getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(Solucion idSolucion) {
        this.idSolucion = idSolucion;
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
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Diagnostico[ idDiagnostico=" + idDiagnostico + " ]";
    }
    
}
