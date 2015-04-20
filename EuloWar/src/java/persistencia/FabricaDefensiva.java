/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "fabrica_defensiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FabricaDefensiva.findAll", query = "SELECT f FROM FabricaDefensiva f"),
    @NamedQuery(name = "FabricaDefensiva.findByIdFabricaDefensiva", query = "SELECT f FROM FabricaDefensiva f WHERE f.fabricaDefensivaPK.idFabricaDefensiva = :idFabricaDefensiva"),
    @NamedQuery(name = "FabricaDefensiva.findByNivelFabricaDefensiva", query = "SELECT f FROM FabricaDefensiva f WHERE f.fabricaDefensivaPK.nivelFabricaDefensiva = :nivelFabricaDefensiva"),
    @NamedQuery(name = "FabricaDefensiva.findByFKFabricaDefensivaUsuario", query = "SELECT f FROM FabricaDefensiva f WHERE f.fabricaDefensivaPK.fKFabricaDefensivaUsuario = :fKFabricaDefensivaUsuario")})
public class FabricaDefensiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FabricaDefensivaPK fabricaDefensivaPK;
    @OneToMany(mappedBy = "fKTropaDefensaFabricaDefensiva")
    private Collection<TropaDefensa> tropaDefensaCollection;
    @JoinColumn(name = "FK_Fabrica_DefensivaUsuario", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public FabricaDefensiva() {
    }

    public FabricaDefensiva(FabricaDefensivaPK fabricaDefensivaPK) {
        this.fabricaDefensivaPK = fabricaDefensivaPK;
    }

    public FabricaDefensiva(int idFabricaDefensiva, int nivelFabricaDefensiva, String fKFabricaDefensivaUsuario) {
        this.fabricaDefensivaPK = new FabricaDefensivaPK(idFabricaDefensiva, nivelFabricaDefensiva, fKFabricaDefensivaUsuario);
    }

    public FabricaDefensivaPK getFabricaDefensivaPK() {
        return fabricaDefensivaPK;
    }

    public void setFabricaDefensivaPK(FabricaDefensivaPK fabricaDefensivaPK) {
        this.fabricaDefensivaPK = fabricaDefensivaPK;
    }

    @XmlTransient
    public Collection<TropaDefensa> getTropaDefensaCollection() {
        return tropaDefensaCollection;
    }

    public void setTropaDefensaCollection(Collection<TropaDefensa> tropaDefensaCollection) {
        this.tropaDefensaCollection = tropaDefensaCollection;
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
        hash += (fabricaDefensivaPK != null ? fabricaDefensivaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabricaDefensiva)) {
            return false;
        }
        FabricaDefensiva other = (FabricaDefensiva) object;
        if ((this.fabricaDefensivaPK == null && other.fabricaDefensivaPK != null) || (this.fabricaDefensivaPK != null && !this.fabricaDefensivaPK.equals(other.fabricaDefensivaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.FabricaDefensiva[ fabricaDefensivaPK=" + fabricaDefensivaPK + " ]";
    }
    
}
