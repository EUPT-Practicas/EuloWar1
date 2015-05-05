/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FranciscoJavier
 */
@Entity
@Table(name = "recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r"),
    @NamedQuery(name = "Recurso.findByIdRecurso", query = "SELECT r FROM Recurso r WHERE r.idRecurso = :idRecurso"),
    @NamedQuery(name = "Recurso.findByTipoRecurso", query = "SELECT r FROM Recurso r WHERE r.tipoRecurso = :tipoRecurso"),
    @NamedQuery(name = "Recurso.findByUnidades", query = "SELECT r FROM Recurso r WHERE r.unidades = :unidades")})
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecurso")
    private Integer idRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoRecurso")
    private String tipoRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKMinaRecurso")
    private Collection<Mina> minaCollection;
    @JoinColumn(name = "FK_Usuario", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Usuario fKUsuario;

    public Recurso() {
    }

    public Recurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Recurso(Integer idRecurso, String tipoRecurso, int unidades) {
        this.idRecurso = idRecurso;
        this.tipoRecurso = tipoRecurso;
        this.unidades = unidades;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @XmlTransient
    public Collection<Mina> getMinaCollection() {
        return minaCollection;
    }

    public void setMinaCollection(Collection<Mina> minaCollection) {
        this.minaCollection = minaCollection;
    }

    public Usuario getFKUsuario() {
        return fKUsuario;
    }

    public void setFKUsuario(Usuario fKUsuario) {
        this.fKUsuario = fKUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recurso[ idRecurso=" + idRecurso + " ]";
    }
    
}
