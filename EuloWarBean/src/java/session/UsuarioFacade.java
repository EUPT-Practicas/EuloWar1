/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByEmail(String email){
        Query q = em.createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        Usuario u = (Usuario) q.getSingleResult();
        return u;
    }
    
    public Usuario findByNombreUsuario(String nombreUsuario){
        Query q = em.createNamedQuery("Usuario.findByNombreUsuario");
        q.setParameter("nombreUsuario", nombreUsuario);
        Usuario u = (Usuario) q.getSingleResult();
        return u;
    }
    
}
