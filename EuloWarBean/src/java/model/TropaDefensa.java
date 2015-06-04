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
@Table(name = "tropa_defensa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TropaDefensa.findAll", query = "SELECT t FROM TropaDefensa t"),
    @NamedQuery(name = "TropaDefensa.findByIdTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.idTropaDefensa = :idTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByTipoTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.tipoTropaDefensa = :tipoTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByNivelTropaDefensa", query = "SELECT t FROM TropaDefensa t WHERE t.nivelTropaDefensa = :nivelTropaDefensa"),
    @NamedQuery(name = "TropaDefensa.findByUnidades", query = "SELECT t FROM TropaDefensa t WHERE t.unidades = :unidades")})
public class TropaDefensa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTropa_Defensa")
    private Integer idTropaDefensa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTropa_Defensa")
    private String tipoTropaDefensa;
    @Column(name = "nivelTropa_Defensa")
    private Integer nivelTropaDefensa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @JoinColumn(name = "FK_Tropa_DefensaUsuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKTropaDefensaUsuario;
    @JoinColumn(name = "FK_Tropa_DefensaFabricaDefensiva", referencedColumnName = "idFabrica_Defensiva")
    @ManyToOne
    private FabricaDefensiva fKTropaDefensaFabricaDefensiva;
    @JoinColumn(name = "FK_Tropa_DefensaCampamento", referencedColumnName = "idCampamento")
    @ManyToOne
    private Campamento fKTropaDefensaCampamento;

    public TropaDefensa() {
    }

    public TropaDefensa(Integer idTropaDefensa) {
        this.idTropaDefensa = idTropaDefensa;
    }

    public TropaDefensa(Integer idTropaDefensa, String tipoTropaDefensa, int unidades) {
        this.idTropaDefensa = idTropaDefensa;
        this.tipoTropaDefensa = tipoTropaDefensa;
        this.unidades = unidades;
    }
    
    public TropaDefensa(String tipoTropaDefensa, int unidades){
        this.tipoTropaDefensa = tipoTropaDefensa;
        this.unidades = unidades;
    }

    public Integer getIdTropaDefensa() {
        return idTropaDefensa;
    }

    public void setIdTropaDefensa(Integer idTropaDefensa) {
        this.idTropaDefensa = idTropaDefensa;
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

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Usuario getFKTropaDefensaUsuario() {
        return fKTropaDefensaUsuario;
    }

    public void setFKTropaDefensaUsuario(Usuario fKTropaDefensaUsuario) {
        this.fKTropaDefensaUsuario = fKTropaDefensaUsuario;
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
        hash += (idTropaDefensa != null ? idTropaDefensa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TropaDefensa)) {
            return false;
        }
        TropaDefensa other = (TropaDefensa) object;
        if ((this.idTropaDefensa == null && other.idTropaDefensa != null) || (this.idTropaDefensa != null && !this.idTropaDefensa.equals(other.idTropaDefensa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TropaDefensa[ idTropaDefensa=" + idTropaDefensa + " ]";
    }
    
}
