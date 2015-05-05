/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Mina;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class MinaFacade extends AbstractFacade<Mina> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MinaFacade() {
        super(Mina.class);
    }
    
}
