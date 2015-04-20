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
public class TropaDefensaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTropa_Defensa")
    private int idTropaDefensa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_Tropa_DefensaUsuario")
    private String fKTropaDefensaUsuario;

    public TropaDefensaPK() {
    }

    public TropaDefensaPK(int idTropaDefensa, String fKTropaDefensaUsuario) {
        this.idTropaDefensa = idTropaDefensa;
        this.fKTropaDefensaUsuario = fKTropaDefensaUsuario;
    }

    public int getIdTropaDefensa() {
        return idTropaDefensa;
    }

    public void setIdTropaDefensa(int idTropaDefensa) {
        this.idTropaDefensa = idTropaDefensa;
    }

    public String getFKTropaDefensaUsuario() {
        return fKTropaDefensaUsuario;
    }

    public void setFKTropaDefensaUsuario(String fKTropaDefensaUsuario) {
        this.fKTropaDefensaUsuario = fKTropaDefensaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTropaDefensa;
        hash += (fKTropaDefensaUsuario != null ? fKTropaDefensaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaDefensaPK)) {
            return false;
        }
        TropaDefensaPK other = (TropaDefensaPK) object;
        if (this.idTropaDefensa != other.idTropaDefensa) {
            return false;
        }
        if ((this.fKTropaDefensaUsuario == null && other.fKTropaDefensaUsuario != null) || (this.fKTropaDefensaUsuario != null && !this.fKTropaDefensaUsuario.equals(other.fKTropaDefensaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TropaDefensaPK[ idTropaDefensa=" + idTropaDefensa + ", fKTropaDefensaUsuario=" + fKTropaDefensaUsuario + " ]";
    }
    
}
