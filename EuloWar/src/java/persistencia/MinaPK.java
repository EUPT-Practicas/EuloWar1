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
public class MinaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMina")
    private int idMina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_MinaUsuario")
    private String fKMinaUsuario;

    public MinaPK() {
    }

    public MinaPK(int idMina, String fKMinaUsuario) {
        this.idMina = idMina;
        this.fKMinaUsuario = fKMinaUsuario;
    }

    public int getIdMina() {
        return idMina;
    }

    public void setIdMina(int idMina) {
        this.idMina = idMina;
    }

    public String getFKMinaUsuario() {
        return fKMinaUsuario;
    }

    public void setFKMinaUsuario(String fKMinaUsuario) {
        this.fKMinaUsuario = fKMinaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMina;
        hash += (fKMinaUsuario != null ? fKMinaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MinaPK)) {
            return false;
        }
        MinaPK other = (MinaPK) object;
        if (this.idMina != other.idMina) {
            return false;
        }
        if ((this.fKMinaUsuario == null && other.fKMinaUsuario != null) || (this.fKMinaUsuario != null && !this.fKMinaUsuario.equals(other.fKMinaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.MinaPK[ idMina=" + idMina + ", fKMinaUsuario=" + fKMinaUsuario + " ]";
    }
    
}
