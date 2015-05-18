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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "i_coste_elementos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ICosteElementos.findAll", query = "SELECT i FROM ICosteElementos i"),
    @NamedQuery(name = "ICosteElementos.findByIdcosteElementos", query = "SELECT i FROM ICosteElementos i WHERE i.idcosteElementos = :idcosteElementos"),
    @NamedQuery(name = "ICosteElementos.findByElemento", query = "SELECT i FROM ICosteElementos i WHERE i.elemento = :elemento"),
    @NamedQuery(name = "ICosteElementos.findByCosteHierro", query = "SELECT i FROM ICosteElementos i WHERE i.costeHierro = :costeHierro"),
    @NamedQuery(name = "ICosteElementos.findByNivelCapacidadMaximo", query = "SELECT i FROM ICosteElementos i WHERE i.nivelCapacidadMaximo = :nivelCapacidadMaximo")})
public class ICosteElementos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcoste_elementos")
    private Integer idcosteElementos;
    @Size(max = 45)
    @Column(name = "elemento")
    private String elemento;
    @Column(name = "coste_hierro")
    private Integer costeHierro;
    @Column(name = "nivel-capacidad_maximo")
    private Integer nivelCapacidadMaximo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;

    public ICosteElementos() {
    }

    public ICosteElementos(Integer idcosteElementos) {
        this.idcosteElementos = idcosteElementos;
    }

    public Integer getIdcosteElementos() {
        return idcosteElementos;
    }

    public void setIdcosteElementos(Integer idcosteElementos) {
        this.idcosteElementos = idcosteElementos;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public Integer getCosteHierro() {
        return costeHierro;
    }

    public void setCosteHierro(Integer costeHierro) {
        this.costeHierro = costeHierro;
    }

    public Integer getNivelCapacidadMaximo() {
        return nivelCapacidadMaximo;
    }

    public void setNivelCapacidadMaximo(Integer nivelCapacidadMaximo) {
        this.nivelCapacidadMaximo = nivelCapacidadMaximo;
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
        hash += (idcosteElementos != null ? idcosteElementos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ICosteElementos)) {
            return false;
        }
        ICosteElementos other = (ICosteElementos) object;
        if ((this.idcosteElementos == null && other.idcosteElementos != null) || (this.idcosteElementos != null && !this.idcosteElementos.equals(other.idcosteElementos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ICosteElementos[ idcosteElementos=" + idcosteElementos + " ]";
    }
    
}
