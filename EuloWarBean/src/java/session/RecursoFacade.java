/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Recurso;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class RecursoFacade extends AbstractFacade<Recurso> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecursoFacade() {
        super(Recurso.class);
    }
    
    public Recurso obtenerRecursosFromEmail(String email){
        Query q = em.createNamedQuery("Recurso.findAll");
        //q.setParameter("email", email);
        List<Recurso> listaRecursos = q.getResultList();
        for (Recurso r : listaRecursos){
            if (r.getFKUsuario().getEmail().equals(email)){
                return r;
            }
        }
        return null;
    }  
    
}
