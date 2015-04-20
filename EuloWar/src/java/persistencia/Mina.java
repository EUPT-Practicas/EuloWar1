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
@Table(name = "mina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mina.findAll", query = "SELECT m FROM Mina m"),
    @NamedQuery(name = "Mina.findByIdMina", query = "SELECT m FROM Mina m WHERE m.minaPK.idMina = :idMina"),
    @NamedQuery(name = "Mina.findByTipoMina", query = "SELECT m FROM Mina m WHERE m.tipoMina = :tipoMina"),
    @NamedQuery(name = "Mina.findByNivelMina", query = "SELECT m FROM Mina m WHERE m.nivelMina = :nivelMina"),
    @NamedQuery(name = "Mina.findByFKMinaUsuario", query = "SELECT m FROM Mina m WHERE m.minaPK.fKMinaUsuario = :fKMinaUsuario")})
public class Mina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MinaPK minaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMina")
    private String tipoMina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelMina")
    private int nivelMina;
    @JoinColumn(name = "FK_MinaRecurso", referencedColumnName = "idRecurso")
    @ManyToOne(optional = false)
    private Recurso fKMinaRecurso;
    @JoinColumn(name = "FK_MinaUsuario", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Mina() {
    }

    public Mina(MinaPK minaPK) {
        this.minaPK = minaPK;
    }

    public Mina(MinaPK minaPK, String tipoMina, int nivelMina) {
        this.minaPK = minaPK;
        this.tipoMina = tipoMina;
        this.nivelMina = nivelMina;
    }

    public Mina(int idMina, String fKMinaUsuario) {
        this.minaPK = new MinaPK(idMina, fKMinaUsuario);
    }

    public MinaPK getMinaPK() {
        return minaPK;
    }

    public void setMinaPK(MinaPK minaPK) {
        this.minaPK = minaPK;
    }

    public String getTipoMina() {
        return tipoMina;
    }

    public void setTipoMina(String tipoMina) {
        this.tipoMina = tipoMina;
    }

    public int getNivelMina() {
        return nivelMina;
    }

    public void setNivelMina(int nivelMina) {
        this.nivelMina = nivelMina;
    }

    public Recurso getFKMinaRecurso() {
        return fKMinaRecurso;
    }

    public void setFKMinaRecurso(Recurso fKMinaRecurso) {
        this.fKMinaRecurso = fKMinaRecurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (minaPK != null ? minaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mina)) {
            return false;
        }
        Mina other = (Mina) object;
        if ((this.minaPK == null && other.minaPK != null) || (this.minaPK != null && !this.minaPK.equals(other.minaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Mina[ minaPK=" + minaPK + " ]";
    }
    
}
