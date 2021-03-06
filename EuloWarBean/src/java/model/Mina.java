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
@Table(name = "mina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mina.findAll", query = "SELECT m FROM Mina m"),
    @NamedQuery(name = "Mina.findByIdMina", query = "SELECT m FROM Mina m WHERE m.idMina = :idMina"),
    @NamedQuery(name = "Mina.findByTipoMina", query = "SELECT m FROM Mina m WHERE m.tipoMina = :tipoMina"),
    @NamedQuery(name = "Mina.findByNivelMina", query = "SELECT m FROM Mina m WHERE m.nivelMina = :nivelMina"),
    @NamedQuery(name = "Mina.findByActualizando", query = "SELECT m FROM Mina m WHERE m.actualizando = :actualizando"),
    @NamedQuery(name = "Mina.findByHoraUltimaActualizacion", query = "SELECT m FROM Mina m WHERE m.horaUltimaActualizacion = :horaUltimaActualizacion")})
public class Mina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMina")
    private Integer idMina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMina")
    private String tipoMina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivelMina")
    private int nivelMina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualizando")
    private int actualizando;
    @Size(max = 45)
    @Column(name = "horaUltimaActualizacion")
    private String horaUltimaActualizacion;
    @JoinColumn(name = "FK_MinaUsuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKMinaUsuario;
    @JoinColumn(name = "FK_MinaRecurso", referencedColumnName = "idRecurso")
    @ManyToOne
    private Recurso fKMinaRecurso;

    public Mina() {
    }

    public Mina(Integer idMina) {
        this.idMina = idMina;
    }
    
    public Mina(String tipoMina, int nivelMina) {
        this.tipoMina = tipoMina;
        this.nivelMina = nivelMina;
    }

    public Mina(Integer idMina, String tipoMina, int nivelMina, int actualizando) {
        this.idMina = idMina;
        this.tipoMina = tipoMina;
        this.nivelMina = nivelMina;
        this.actualizando = actualizando;
    }

    public Integer getIdMina() {
        return idMina;
    }

    public void setIdMina(Integer idMina) {
        this.idMina = idMina;
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

    public int getActualizando() {
        return actualizando;
    }

    public void setActualizando(int actualizando) {
        this.actualizando = actualizando;
    }

    public String getHoraUltimaActualizacion() {
        return horaUltimaActualizacion;
    }

    public void setHoraUltimaActualizacion(String horaUltimaActualizacion) {
        this.horaUltimaActualizacion = horaUltimaActualizacion;
    }

    public Usuario getFKMinaUsuario() {
        return fKMinaUsuario;
    }

    public void setFKMinaUsuario(Usuario fKMinaUsuario) {
        this.fKMinaUsuario = fKMinaUsuario;
    }

    public Recurso getFKMinaRecurso() {
        return fKMinaRecurso;
    }

    public void setFKMinaRecurso(Recurso fKMinaRecurso) {
        this.fKMinaRecurso = fKMinaRecurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMina != null ? idMina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mina)) {
            return false;
        }
        Mina other = (Mina) object;
        if ((this.idMina == null && other.idMina != null) || (this.idMina != null && !this.idMina.equals(other.idMina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mina[ idMina=" + idMina + " ]";
    }
    
}
