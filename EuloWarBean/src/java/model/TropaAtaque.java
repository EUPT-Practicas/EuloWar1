/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "TropaAtaque.findByIdTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.idTropaAtaque = :idTropaAtaque"),
    @NamedQuery(name = "TropaAtaque.findByTipoTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.tipoTropaAtaque = :tipoTropaAtaque"),
    @NamedQuery(name = "TropaAtaque.findByNivelTropaAtaque", query = "SELECT t FROM TropaAtaque t WHERE t.nivelTropaAtaque = :nivelTropaAtaque")})
public class TropaAtaque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTropa_Ataque")
    private Integer idTropaAtaque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTropa_Ataque")
    private String tipoTropaAtaque;
    @Column(name = "nivelTropa_Ataque")
    private Integer nivelTropaAtaque;
    @JoinColumn(name = "FK_Tropa_AtaqueUsuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKTropaAtaqueUsuario;
    @JoinColumn(name = "FK_Tropa_AtaqueFabricaOfensiva", referencedColumnName = "idFabrica_Ofensiva")
    @ManyToOne
    private FabricaOfensiva fKTropaAtaqueFabricaOfensiva;
    @JoinColumn(name = "FK_Tropa_AtaqueCampamento", referencedColumnName = "idCampamento")
    @ManyToOne
    private Campamento fKTropaAtaqueCampamento;

    public TropaAtaque() {
    }

    public TropaAtaque(Integer idTropaAtaque) {
        this.idTropaAtaque = idTropaAtaque;
    }

    public TropaAtaque(Integer idTropaAtaque, String tipoTropaAtaque) {
        this.idTropaAtaque = idTropaAtaque;
        this.tipoTropaAtaque = tipoTropaAtaque;
    }

    public Integer getIdTropaAtaque() {
        return idTropaAtaque;
    }

    public void setIdTropaAtaque(Integer idTropaAtaque) {
        this.idTropaAtaque = idTropaAtaque;
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

    public Usuario getFKTropaAtaqueUsuario() {
        return fKTropaAtaqueUsuario;
    }

    public void setFKTropaAtaqueUsuario(Usuario fKTropaAtaqueUsuario) {
        this.fKTropaAtaqueUsuario = fKTropaAtaqueUsuario;
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
        hash += (idTropaAtaque != null ? idTropaAtaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaAtaque)) {
            return false;
        }
        TropaAtaque other = (TropaAtaque) object;
        if ((this.idTropaAtaque == null && other.idTropaAtaque != null) || (this.idTropaAtaque != null && !this.idTropaAtaque.equals(other.idTropaAtaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TropaAtaque[ idTropaAtaque=" + idTropaAtaque + " ]";
    }
    
}
