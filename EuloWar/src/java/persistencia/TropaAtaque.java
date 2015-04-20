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
@Table(name = "tropa_ataque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TropaAtaque.findAll", query = "SELECT t FROM TropaAtaque t"),
    @NamedQuery(name = "TropaAtaque.findByIdTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.tropaAtaquePK.idTropaAtaque = :idTropaAtaque"),
    @NamedQuery(name = "TropaAtaque.findByTipoTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.tipoTropaAtaque = :tipoTropaAtaque"),
    @NamedQuery(name = "TropaAtaque.findByNivelTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.nivelTropaAtaque = :nivelTropaAtaque"),
    @NamedQuery(name = "TropaAtaque.findByFKTropaAtaqueUsuario", query = "SELECT t FROM TropaAtaque t WHERE t.tropaAtaquePK.fKTropaAtaqueUsuario = :fKTropaAtaqueUsuario")})
public class TropaAtaque implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TropaAtaquePK tropaAtaquePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTropa_Ataque")
    private String tipoTropaAtaque;
    @Column(name = "nivelTropa_Ataque")
    private Integer nivelTropaAtaque;
    @JoinColumn(name = "FK_Tropa_AtaqueUsuario", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "FK_Tropa_AtaqueFabricaOfensiva", referencedColumnName = "idFabrica_Ofensiva")
    @ManyToOne
    private FabricaOfensiva fKTropaAtaqueFabricaOfensiva;
    @JoinColumn(name = "FK_Tropa_AtaqueCampamento", referencedColumnName = "idCampamento")
    @ManyToOne
    private Campamento fKTropaAtaqueCampamento;

    public TropaAtaque() {
    }

    public TropaAtaque(TropaAtaquePK tropaAtaquePK) {
        this.tropaAtaquePK = tropaAtaquePK;
    }

    public TropaAtaque(TropaAtaquePK tropaAtaquePK, String tipoTropaAtaque) {
        this.tropaAtaquePK = tropaAtaquePK;
        this.tipoTropaAtaque = tipoTropaAtaque;
    }

    public TropaAtaque(int idTropaAtaque, String fKTropaAtaqueUsuario) {
        this.tropaAtaquePK = new TropaAtaquePK(idTropaAtaque, fKTropaAtaqueUsuario);
    }

    public TropaAtaquePK getTropaAtaquePK() {
        return tropaAtaquePK;
    }

    public void setTropaAtaquePK(TropaAtaquePK tropaAtaquePK) {
        this.tropaAtaquePK = tropaAtaquePK;
    }

    public String getTipoTropaAtaque() {
        return tipoTropaAtaque;
    }

    public void setTipoTropaAtaque(String tipoTropaAtaque) {
        this.tipoTropaAtaque = tipoTropaAtaque;
    }

    public Integer getNivelTropaAtaque() {
        return nivelTropaAtaque;
    }

    public void setNivelTropaAtaque(Integer nivelTropaAtaque) {
        this.nivelTropaAtaque = nivelTropaAtaque;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FabricaOfensiva getFKTropaAtaqueFabricaOfensiva() {
        return fKTropaAtaqueFabricaOfensiva;
    }

    public void setFKTropaAtaqueFabricaOfensiva(FabricaOfensiva fKTropaAtaqueFabricaOfensiva) {
        this.fKTropaAtaqueFabricaOfensiva = fKTropaAtaqueFabricaOfensiva;
    }

    public Campamento getFKTropaAtaqueCampamento() {
        return fKTropaAtaqueCampamento;
    }

    public void setFKTropaAtaqueCampamento(Campamento fKTropaAtaqueCampamento) {
        this.fKTropaAtaqueCampamento = fKTropaAtaqueCampamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tropaAtaquePK != null ? tropaAtaquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaAtaque)) {
            return false;
        }
        TropaAtaque other = (TropaAtaque) object;
        if ((this.tropaAtaquePK == null && other.tropaAtaquePK != null) || (this.tropaAtaquePK != null && !this.tropaAtaquePK.equals(other.tropaAtaquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TropaAtaque[ tropaAtaquePK=" + tropaAtaquePK + " ]";
    }
    
}
