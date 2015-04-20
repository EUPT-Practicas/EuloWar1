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
public class CampamentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCampamento")
    private int idCampamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FK_CampamentoUsuario")
    private String fKCampamentoUsuario;

    public CampamentoPK() {
    }

    public CampamentoPK(int idCampamento, String fKCampamentoUsuario) {
        this.idCampamento = idCampamento;
        this.fKCampamentoUsuario = fKCampamentoUsuario;
    }

    public int getIdCampamento() {
        return idCampamento;
    }

    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    public String getFKCampamentoUsuario() {
        return fKCampamentoUsuario;
    }

    public void setFKCampamentoUsuario(String fKCampamentoUsuario) {
        this.fKCampamentoUsuario = fKCampamentoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCampamento;
        hash += (fKCampamentoUsuario != null ? fKCampamentoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampamentoPK)) {
            return false;
        }
        CampamentoPK other = (CampamentoPK) object;
        if (this.idCampamento != other.idCampamento) {
            return false;
        }
        if ((this.fKCampamentoUsuario == null && other.fKCampamentoUsuario != null) || (this.fKCampamentoUsuario != null && !this.fKCampamentoUsuario.equals(other.fKCampamentoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.CampamentoPK[ idCampamento=" + idCampamento + ", fKCampamentoUsuario=" + fKCampamentoUsuario + " ]";
    }
    
}
