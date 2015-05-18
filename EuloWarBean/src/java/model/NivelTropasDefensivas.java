/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "nivel_tropas_defensivas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelTropasDefensivas.findAll", query = "SELECT n FROM NivelTropasDefensivas n"),
    @NamedQuery(name = "NivelTropasDefensivas.findByIdnivelTropasDefensivas", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.idnivelTropasDefensivas = :idnivelTropasDefensivas"),
    @NamedQuery(name = "NivelTropasDefensivas.findByTipoTropa", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.tipoTropa = :tipoTropa"),
    @NamedQuery(name = "NivelTropasDefensivas.findByNivelRequerido", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.nivelRequerido = :nivelRequerido"),
    @NamedQuery(name = "NivelTropasDefensivas.findByNivel", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.nivel = :nivel"),
    @NamedQuery(name = "NivelTropasDefensivas.findByPrecio", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.precio = :precio"),
    @NamedQuery(name = "NivelTropasDefensivas.findByFuerza", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.fuerza = :fuerza"),
    @NamedQuery(name = "NivelTropasDefensivas.findByOcupacion", query = "SELECT n FROM NivelTropasDefensivas n WHERE n.ocupacion = :ocupacion")})
public class NivelTropasDefensivas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnivel_tropas_defensivas")
    private Integer idnivelTropasDefensivas;
    @Size(max = 50)
    @Column(name = "tipoTropa")
    private String tipoTropa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelRequerido")
    private int nivelRequerido;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "fuerza")
    private Integer fuerza;
    @Column(name = "ocupacion")
    private Integer ocupacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;

    public NivelTropasDefensivas() {
    }

    public NivelTropasDefensivas(Integer idnivelTropasDefensivas) {
        this.idnivelTropasDefensivas = idnivelTropasDefensivas;
    }

    public NivelTropasDefensivas(Integer idnivelTropasDefensivas, int nivelRequerido) {
        this.idnivelTropasDefensivas = idnivelTropasDefensivas;
        this.nivelRequerido = nivelRequerido;
    }

    public Integer getIdnivelTropasDefensivas() {
        return idnivelTropasDefensivas;
    }

    public void setIdnivelTropasDefensivas(Integer idnivelTropasDefensivas) {
        this.idnivelTropasDefensivas = idnivelTropasDefensivas;
    }

    public String getTipoTropa() {
        return tipoTropa;
    }

    public void setTipoTropa(String tipoTropa) {
        this.tipoTropa = tipoTropa;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public void setNivelRequerido(int nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Integer ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivelTropasDefensivas != null ? idnivelTropasDefensivas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelTropasDefensivas)) {
            return false;
        }
        NivelTropasDefensivas other = (NivelTropasDefensivas) object;
        if ((this.idnivelTropasDefensivas == null && other.idnivelTropasDefensivas != null) || (this.idnivelTropasDefensivas != null && !this.idnivelTropasDefensivas.equals(other.idnivelTropasDefensivas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NivelTropasDefensivas[ idnivelTropasDefensivas=" + idnivelTropasDefensivas + " ]";
    }
    
}
