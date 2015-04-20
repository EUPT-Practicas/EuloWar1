/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author FranciscoJavier
 */
@Embeddable
public class FabricaDefensivaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idFabrica_Defensiva")
    private int idFabricaDefensiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelFabrica_Defensiva")
    private int nivelFabricaDefensiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_Fabrica_DefensivaUsuario")
    private String fKFabricaDefensivaUsuario;

    public FabricaDefensivaPK() {
    }

    public FabricaDefensivaPK(int idFabricaDefensiva, int nivelFabricaDefensiva, String fKFabricaDefensivaUsuario) {
        this.idFabricaDefensiva = idFabricaDefensiva;
        this.nivelFabricaDefensiva = nivelFabricaDefensiva;
        this.fKFabricaDefensivaUsuario = fKFabricaDefensivaUsuario;
    }

    public int getIdFabricaDefensiva() {
        return idFabricaDefensiva;
    }

    public void setIdFabricaDefensiva(int idFabricaDefensiva) {
        this.idFabricaDefensiva = idFabricaDefensiva;
    }

    public int getNivelFabricaDefensiva() {
        return nivelFabricaDefensiva;
    }

    public void setNivelFabricaDefensiva(int nivelFabricaDefensiva) {
        this.nivelFabricaDefensiva = nivelFabricaDefensiva;
    }

    public String getFKFabricaDefensivaUsuario() {
        return fKFabricaDefensivaUsuario;
    }

    public void setFKFabricaDefensivaUsuario(String fKFabricaDefensivaUsuario) {
        this.fKFabricaDefensivaUsuario = fKFabricaDefensivaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFabricaDefensiva;
        hash += (int) nivelFabricaDefensiva;
        hash += (fKFabricaDefensivaUsuario != null ? fKFabricaDefensivaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabricaDefensivaPK)) {
            return false;
        }
        FabricaDefensivaPK other = (FabricaDefensivaPK) object;
        if (this.idFabricaDefensiva != other.idFabricaDefensiva) {
            return false;
        }
        if (this.nivelFabricaDefensiva != other.nivelFabricaDefensiva) {
            return false;
        }
        if ((this.fKFabricaDefensivaUsuario == null && other.fKFabricaDefensivaUsuario != null) || (this.fKFabricaDefensivaUsuario != null && !this.fKFabricaDefensivaUsuario.equals(other.fKFabricaDefensivaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.FabricaDefensivaPK[ idFabricaDefensiva=" + idFabricaDefensiva + ", nivelFabricaDefensiva=" + nivelFabricaDefensiva + ", fKFabricaDefensivaUsuario=" + fKFabricaDefensivaUsuario + " ]";
    }
    
}
