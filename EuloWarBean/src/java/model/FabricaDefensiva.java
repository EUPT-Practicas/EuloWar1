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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "fabrica_defensiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FabricaDefensiva.findAll", query = "SELECT f FROM FabricaDefensiva f"),
    @NamedQuery(name = "FabricaDefensiva.findByIdFabricaDefensiva", query = "SELECT f FROM FabricaDefensiva f WHERE f.idFabricaDefensiva = :idFabricaDefensiva"),
    @NamedQuery(name = "FabricaDefensiva.findByNivelFabricaDefensiva", query = "SELECT f FROM FabricaDefensiva f WHERE f.nivelFabricaDefensiva = :nivelFabricaDefensiva")})
public class FabricaDefensiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFabrica_Defensiva")
    private Integer idFabricaDefensiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelFabrica_Defensiva")
    private int nivelFabricaDefensiva;
    @OneToMany(mappedBy = "fKTropaDefensaFabricaDefensiva")
    private Collection<TropaDefensa> tropaDefensaCollection;
    @JoinColumn(name = "FK_Fabrica_DefensivaUsuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKFabricaDefensivaUsuario;

    public FabricaDefensiva() {
    }
    
    public FabricaDefensiva(int nivelFabricaDefensiva){
        this.nivelFabricaDefensiva = nivelFabricaDefensiva;
    }

    public FabricaDefensiva(Integer idFabricaDefensiva) {
        this.idFabricaDefensiva = idFabricaDefensiva;
    }

    public FabricaDefensiva(Integer idFabricaDefensiva, int nivelFabricaDefensiva) {
        this.idFabricaDefensiva = idFabricaDefensiva;
        this.nivelFabricaDefensiva = nivelFabricaDefensiva;
    }

    public Integer getIdFabricaDefensiva() {
        return idFabricaDefensiva;
    }

    public void setIdFabricaDefensiva(Integer idFabricaDefensiva) {
        this.idFabricaDefensiva = idFabricaDefensiva;
    }

    public int getNivelFabricaDefensiva() {
        return nivelFabricaDefensiva;
    }

    public void setNivelFabricaDefensiva(int nivelFabricaDefensiva) {
        this.nivelFabricaDefensiva = nivelFabricaDefensiva;
    }

    @XmlTransient
    public Collection<TropaDefensa> getTropaDefensaCollection() {
        return tropaDefensaCollection;
    }

    public void setTropaDefensaCollection(Collection<TropaDefensa> tropaDefensaCollection) {
        this.tropaDefensaCollection = tropaDefensaCollection;
    }

    public Usuario getFKFabricaDefensivaUsuario() {
        return fKFabricaDefensivaUsuario;
    }

    public void setFKFabricaDefensivaUsuario(Usuario fKFabricaDefensivaUsuario) {
        this.fKFabricaDefensivaUsuario = fKFabricaDefensivaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricaDefensiva != null ? idFabricaDefensiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabricaDefensiva)) {
            return false;
        }
        FabricaDefensiva other = (FabricaDefensiva) object;
        if ((this.idFabricaDefensiva == null && other.idFabricaDefensiva != null) || (this.idFabricaDefensiva != null && !this.idFabricaDefensiva.equals(other.idFabricaDefensiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FabricaDefensiva[ idFabricaDefensiva=" + idFabricaDefensiva + " ]";
    }
    
}
