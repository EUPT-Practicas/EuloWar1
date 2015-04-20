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
public class TropaAtaquePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTropa_Ataque")
    private int idTropaAtaque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_Tropa_AtaqueUsuario")
    private String fKTropaAtaqueUsuario;

    public TropaAtaquePK() {
    }

    public TropaAtaquePK(int idTropaAtaque, String fKTropaAtaqueUsuario) {
        this.idTropaAtaque = idTropaAtaque;
        this.fKTropaAtaqueUsuario = fKTropaAtaqueUsuario;
    }

    public int getIdTropaAtaque() {
        return idTropaAtaque;
    }

    public void setIdTropaAtaque(int idTropaAtaque) {
        this.idTropaAtaque = idTropaAtaque;
    }

    public String getFKTropaAtaqueUsuario() {
        return fKTropaAtaqueUsuario;
    }

    public void setFKTropaAtaqueUsuario(String fKTropaAtaqueUsuario) {
        this.fKTropaAtaqueUsuario = fKTropaAtaqueUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTropaAtaque;
        hash += (fKTropaAtaqueUsuario != null ? fKTropaAtaqueUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaAtaquePK)) {
            return false;
        }
        TropaAtaquePK other = (TropaAtaquePK) object;
        if (this.idTropaAtaque != other.idTropaAtaque) {
            return false;
        }
        if ((this.fKTropaAtaqueUsuario == null && other.fKTropaAtaqueUsuario != null) || (this.fKTropaAtaqueUsuario != null && !this.fKTropaAtaqueUsuario.equals(other.fKTropaAtaqueUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TropaAtaquePK[ idTropaAtaque=" + idTropaAtaque + ", fKTropaAtaqueUsuario=" + fKTropaAtaqueUsuario + " ]";
    }
    
}
