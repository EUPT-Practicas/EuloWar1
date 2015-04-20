/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Recurso.findByIdRecurso", query = "SELECT r FROM Recurso r WHERE r.recursoPK.idRecurso = :idRecurso"),
    @NamedQuery(name = "Recurso.findByTipoRecurso", query = "SELECT r FROM Recurso r WHERE r.tipoRecurso = :tipoRecurso"),
    @NamedQuery(name = "Recurso.findByUnidades", query = "SELECT r FROM Recurso r WHERE r.unidades = :unidades"),
    @NamedQuery(name = "Recurso.findByFKUsuario", query = "SELECT r FROM Recurso r WHERE r.recursoPK.fKUsuario = :fKUsuario")})
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecursoPK recursoPK;
    @Size(max = 45)
    @Column(name = "tipoRecurso")
    private String tipoRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKMinaRecurso")
    private Collection<Mina> minaCollection;
    @JoinColumn(name = "FK_Usuario", referencedColumnName = "email", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Recurso() {
    }

    public Recurso(RecursoPK recursoPK) {
        this.recursoPK = recursoPK;
    }

    public Recurso(RecursoPK recursoPK, int unidades) {
        this.recursoPK = recursoPK;
        this.unidades = unidades;
    }

    public Recurso(int idRecurso, String fKUsuario) {
        this.recursoPK = new RecursoPK(idRecurso, fKUsuario);
    }

    public RecursoPK getRecursoPK() {
        return recursoPK;
    }

    public void setRecursoPK(RecursoPK recursoPK) {
        this.recursoPK = recursoPK;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recursoPK != null ? recursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.recursoPK == null && other.recursoPK != null) || (this.recursoPK != null && !this.recursoPK.equals(other.recursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Recurso[ recursoPK=" + recursoPK + " ]";
    }
    
}
