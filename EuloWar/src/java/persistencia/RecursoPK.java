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
public class RecursoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idRecurso")
    private int idRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_Usuario")
    private String fKUsuario;

    public RecursoPK() {
    }

    public RecursoPK(int idRecurso, String fKUsuario) {
        this.idRecurso = idRecurso;
        this.fKUsuario = fKUsuario;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getFKUsuario() {
        return fKUsuario;
    }

    public void setFKUsuario(String fKUsuario) {
        this.fKUsuario = fKUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRecurso;
        hash += (fKUsuario != null ? fKUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoPK)) {
            return false;
        }
        RecursoPK other = (RecursoPK) object;
        if (this.idRecurso != other.idRecurso) {
            return false;
        }
        if ((this.fKUsuario == null && other.fKUsuario != null) || (this.fKUsuario != null && !this.fKUsuario.equals(other.fKUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.RecursoPK[ idRecurso=" + idRecurso + ", fKUsuario=" + fKUsuario + " ]";
    }
    
}
