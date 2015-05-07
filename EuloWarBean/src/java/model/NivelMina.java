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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "nivel_mina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelMina.findAll", query = "SELECT n FROM NivelMina n"),
    @NamedQuery(name = "NivelMina.findByNivel", query = "SELECT n FROM NivelMina n WHERE n.nivel = :nivel"),
    @NamedQuery(name = "NivelMina.findByGanancia", query = "SELECT n FROM NivelMina n WHERE n.ganancia = :ganancia"),
    @NamedQuery(name = "NivelMina.findByPrecio", query = "SELECT n FROM NivelMina n WHERE n.precio = :precio")})
public class NivelMina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "ganancia")
    private Integer ganancia;
    @Column(name = "precio")
    private Integer precio;

    public NivelMina() {
    }

    public NivelMina(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getGanancia() {
        return ganancia;
    }

    public void setGanancia(Integer ganancia) {
        this.ganancia = ganancia;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivel != null ? nivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelMina)) {
            return false;
        }
        NivelMina other = (NivelMina) object;
        if ((this.nivel == null && other.nivel != null) || (this.nivel != null && !this.nivel.equals(other.nivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NivelMina[ nivel=" + nivel + " ]";
    }
    
}
