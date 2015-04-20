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
public class FabricaOfensivaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idFabrica_Ofensiva")
    private int idFabricaOfensiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_Fabrica_OfensivaUsuario")
    private String fKFabricaOfensivaUsuario;

    public FabricaOfensivaPK() {
    }

    public FabricaOfensivaPK(int idFabricaOfensiva, String fKFabricaOfensivaUsuario) {
        this.idFabricaOfensiva = idFabricaOfensiva;
        this.fKFabricaOfensivaUsuario = fKFabricaOfensivaUsuario;
    }

    public int getIdFabricaOfensiva() {
        return idFabricaOfensiva;
    }

    public void setIdFabricaOfensiva(int idFabricaOfensiva) {
        this.idFabricaOfensiva = idFabricaOfensiva;
    }

    public String getFKFabricaOfensivaUsuario() {
        return fKFabricaOfensivaUsuario;
    }

    public void setFKFabricaOfensivaUsuario(String fKFabricaOfensivaUsuario) {
        this.fKFabricaOfensivaUsuario = fKFabricaOfensivaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFabricaOfensiva;
        hash += (fKFabricaOfensivaUsuario != null ? fKFabricaOfensivaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabricaOfensivaPK)) {
            return false;
        }
        FabricaOfensivaPK other = (FabricaOfensivaPK) object;
        if (this.idFabricaOfensiva != other.idFabricaOfensiva) {
            return false;
        }
        if ((this.fKFabricaOfensivaUsuario == null && other.fKFabricaOfensivaUsuario != null) || (this.fKFabricaOfensivaUsuario != null && !this.fKFabricaOfensivaUsuario.equals(other.fKFabricaOfensivaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.FabricaOfensivaPK[ idFabricaOfensiva=" + idFabricaOfensiva + ", fKFabricaOfensivaUsuario=" + fKFabricaOfensivaUsuario + " ]";
    }
    
}
