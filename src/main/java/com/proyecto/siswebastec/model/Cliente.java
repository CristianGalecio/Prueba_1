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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private int idPerfil;
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
    @Column(name = "CARGO_CLIENTE")
    private String cargoCliente;
    @Column(name = "ANEXO_CLIENTE")
    private Integer anexoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Solicitud> solicitudList;
    @JoinColumn(name = "ID_AREA", referencedColumnName = "ID_AREA")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(ClientePK clientePK, int idPerfil) {
        this.clientePK = clientePK;
        this.idPerfil = idPerfil;
    }

    public Cliente(int idUsuario, String idCliente) {
        this.clientePK = new ClientePK(idUsuario, idCliente);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
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

    public String getCargoCliente() {
        return cargoCliente;
    }

    public void setCargoCliente(String cargoCliente) {
        this.cargoCliente = cargoCliente;
    }

    public Integer getAnexoCliente() {
        return anexoCliente;
    }

    public void setAnexoCliente(Integer anexoCliente) {
        this.anexoCliente = anexoCliente;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyecto.siswebastec.model.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
