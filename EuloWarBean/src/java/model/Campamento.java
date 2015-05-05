/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "campamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campamento.findAll", query = "SELECT c FROM Campamento c"),
    @NamedQuery(name = "Campamento.findByIdCampamento", query = "SELECT c FROM Campamento c WHERE c.idCampamento = :idCampamento"),
    @NamedQuery(name = "Campamento.findByTropasLibres", query = "SELECT c FROM Campamento c WHERE c.tropasLibres = :tropasLibres"),
    @NamedQuery(name = "Campamento.findByTropasAlmacenadas", query = "SELECT c FROM Campamento c WHERE c.tropasAlmacenadas = :tropasAlmacenadas")})
public class Campamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCampamento")
    private Integer idCampamento;
    @Column(name = "tropasLibres")
    private Integer tropasLibres;
    @Column(name = "tropasAlmacenadas")
    private Integer tropasAlmacenadas;
    @OneToMany(mappedBy = "fKTropaAtaqueCampamento")
    private Collection<TropaAtaque> tropaAtaqueCollection;
    @OneToMany(mappedBy = "fKTropaDefensaCampamento")
    private Collection<TropaDefensa> tropaDefensaCollection;
    @JoinColumn(name = "FK_CampamentoUsuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKCampamentoUsuario;

    public Campamento() {
    }

    public Campamento(Integer idCampamento) {
        this.idCampamento = idCampamento;
    }

    public Integer getIdCampamento() {
        return idCampamento;
    }

    public void setIdCampamento(Integer idCampamento) {
        this.idCampamento = idCampamento;
    }

    public Integer getTropasLibres() {
        return tropasLibres;
    }

    public void setTropasLibres(Integer tropasLibres) {
        this.tropasLibres = tropasLibres;
    }

    public Integer getTropasAlmacenadas() {
        return tropasAlmacenadas;
    }

    public void setTropasAlmacenadas(Integer tropasAlmacenadas) {
        this.tropasAlmacenadas = tropasAlmacenadas;
    }

    @XmlTransient
    public Collection<TropaAtaque> getTropaAtaqueCollection() {
        return tropaAtaqueCollection;
    }

    public void setTropaAtaqueCollection(Collection<TropaAtaque> tropaAtaqueCollection) {
        this.tropaAtaqueCollection = tropaAtaqueCollection;
    }

    @XmlTransient
    public Collection<TropaDefensa> getTropaDefensaCollection() {
        return tropaDefensaCollection;
    }

    public void setTropaDefensaCollection(Collection<TropaDefensa> tropaDefensaCollection) {
        this.tropaDefensaCollection = tropaDefensaCollection;
    }

    public Usuario getFKCampamentoUsuario() {
        return fKCampamentoUsuario;
    }

    public void setFKCampamentoUsuario(Usuario fKCampamentoUsuario) {
        this.fKCampamentoUsuario = fKCampamentoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampamento != null ? idCampamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campamento)) {
            return false;
        }
        Campamento other = (Campamento) object;
        if ((this.idCampamento == null && other.idCampamento != null) || (this.idCampamento != null && !this.idCampamento.equals(other.idCampamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Campamento[ idCampamento=" + idCampamento + " ]";
    }
    
}
