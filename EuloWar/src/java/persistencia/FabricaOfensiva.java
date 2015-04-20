/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "fabrica_ofensiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FabricaOfensiva.findAll", query = "SELECT f FROM FabricaOfensiva f"),
    @NamedQuery(name = "FabricaOfensiva.findByIdFabricaOfensiva", query = "SELECT f FROM FabricaOfensiva f WHERE f.fabricaOfensivaPK.idFabricaOfensiva = :idFabricaOfensiva"),
    @NamedQuery(name = "FabricaOfensiva.findByNivelFabricaOfensiva", query = "SELECT f FROM FabricaOfensiva f WHERE f.nivelFabricaOfensiva = :nivelFabricaOfensiva"),
    @NamedQuery(name = "FabricaOfensiva.findByFKFabricaOfensivaUsuario", query = "SELECT f FROM FabricaOfensiva f WHERE f.fabricaOfensivaPK.fKFabricaOfensivaUsuario = :fKFabricaOfensivaUsuario")})
public class FabricaOfensiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FabricaOfensivaPK fabricaOfensivaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelFabrica_Ofensiva")
    private int nivelFabricaOfensiva;
    @OneToMany(mappedBy = "fKTropaAtaqueFabricaOfensiva")
    private Collection<TropaAtaque> tropaAtaqueCollection;

    public FabricaOfensiva() {
    }

    public FabricaOfensiva(FabricaOfensivaPK fabricaOfensivaPK) {
        this.fabricaOfensivaPK = fabricaOfensivaPK;
    }

    public FabricaOfensiva(FabricaOfensivaPK fabricaOfensivaPK, int nivelFabricaOfensiva) {
        this.fabricaOfensivaPK = fabricaOfensivaPK;
        this.nivelFabricaOfensiva = nivelFabricaOfensiva;
    }

    public FabricaOfensiva(int idFabricaOfensiva, String fKFabricaOfensivaUsuario) {
        this.fabricaOfensivaPK = new FabricaOfensivaPK(idFabricaOfensiva, fKFabricaOfensivaUsuario);
    }

    public FabricaOfensivaPK getFabricaOfensivaPK() {
        return fabricaOfensivaPK;
    }

    public void setFabricaOfensivaPK(FabricaOfensivaPK fabricaOfensivaPK) {
        this.fabricaOfensivaPK = fabricaOfensivaPK;
    }

    public int getNivelFabricaOfensiva() {
        return nivelFabricaOfensiva;
    }

    public void setNivelFabricaOfensiva(int nivelFabricaOfensiva) {
        this.nivelFabricaOfensiva = nivelFabricaOfensiva;
    }

    @XmlTransient
    public Collection<TropaAtaque> getTropaAtaqueCollection() {
        return tropaAtaqueCollection;
    }

    public void setTropaAtaqueCollection(Collection<TropaAtaque> tropaAtaqueCollection) {
        this.tropaAtaqueCollection = tropaAtaqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fabricaOfensivaPK != null ? fabricaOfensivaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabricaOfensiva)) {
            return false;
        }
        FabricaOfensiva other = (FabricaOfensiva) object;
        if ((this.fabricaOfensivaPK == null && other.fabricaOfensivaPK != null) || (this.fabricaOfensivaPK != null && !this.fabricaOfensivaPK.equals(other.fabricaOfensivaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.FabricaOfensiva[ fabricaOfensivaPK=" + fabricaOfensivaPK + " ]";
    }
    
}
