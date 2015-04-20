/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "tropa_defensa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TropaDefensa.findAll", query = "SELECT t FROM TropaDefensa t"),
    @NamedQuery(name = "TropaDefensa.findByIdTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.tropaDefensaPK.idTropaDefensa = :idTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByTipoTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.tipoTropaDefensa = :tipoTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByNivelTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.nivelTropaDefensa = :nivelTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByFKTropaDefensaUsuario", query = "SELECT t FROM TropaDefensa t WHERE t.tropaDefensaPK.fKTropaDefensaUsuario = :fKTropaDefensaUsuario")})
public class TropaDefensa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TropaDefensaPK tropaDefensaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTropa_Defensa")
    private String tipoTropaDefensa;
    @Column(name = "nivelTropa_Defensa")
    private Integer nivelTropaDefensa;
    @JoinColumn(name = "FK_Tropa_DefensaUsuario", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "FK_Tropa_DefensaFabricaDefensiva", referencedColumnName = "idFabrica_Defensiva")
    @ManyToOne
    private FabricaDefensiva fKTropaDefensaFabricaDefensiva;
    @JoinColumn(name = "FK_Tropa_DefensaCampamento", referencedColumnName = "idCampamento")
    @ManyToOne
    private Campamento fKTropaDefensaCampamento;

    public TropaDefensa() {
    }

    public TropaDefensa(TropaDefensaPK tropaDefensaPK) {
        this.tropaDefensaPK = tropaDefensaPK;
    }

    public TropaDefensa(TropaDefensaPK tropaDefensaPK, String tipoTropaDefensa) {
        this.tropaDefensaPK = tropaDefensaPK;
        this.tipoTropaDefensa = tipoTropaDefensa;
    }

    public TropaDefensa(int idTropaDefensa, String fKTropaDefensaUsuario) {
        this.tropaDefensaPK = new TropaDefensaPK(idTropaDefensa, fKTropaDefensaUsuario);
    }

    public TropaDefensaPK getTropaDefensaPK() {
        return tropaDefensaPK;
    }

    public void setTropaDefensaPK(TropaDefensaPK tropaDefensaPK) {
        this.tropaDefensaPK = tropaDefensaPK;
    }

    public String getTipoTropaDefensa() {
        return tipoTropaDefensa;
    }

    public void setTipoTropaDefensa(String tipoTropaDefensa) {
        this.tipoTropaDefensa = tipoTropaDefensa;
    }

    public Integer getNivelTropaDefensa() {
        return nivelTropaDefensa;
    }

    public void setNivelTropaDefensa(Integer nivelTropaDefensa) {
        this.nivelTropaDefensa = nivelTropaDefensa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FabricaDefensiva getFKTropaDefensaFabricaDefensiva() {
        return fKTropaDefensaFabricaDefensiva;
    }

    public void setFKTropaDefensaFabricaDefensiva(FabricaDefensiva fKTropaDefensaFabricaDefensiva) {
        this.fKTropaDefensaFabricaDefensiva = fKTropaDefensaFabricaDefensiva;
    }

    public Campamento getFKTropaDefensaCampamento() {
        return fKTropaDefensaCampamento;
    }

    public void setFKTropaDefensaCampamento(Campamento fKTropaDefensaCampamento) {
        this.fKTropaDefensaCampamento = fKTropaDefensaCampamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tropaDefensaPK != null ? tropaDefensaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaDefensa)) {
            return false;
        }
        TropaDefensa other = (TropaDefensa) object;
        if ((this.tropaDefensaPK == null && other.tropaDefensaPK != null) || (this.tropaDefensaPK != null && !this.tropaDefensaPK.equals(other.tropaDefensaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TropaDefensa[ tropaDefensaPK=" + tropaDefensaPK + " ]";
    }
    
}
