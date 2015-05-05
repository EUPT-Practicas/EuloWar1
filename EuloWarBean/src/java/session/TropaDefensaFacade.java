/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.TropaDefensa;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class TropaDefensaFacade extends AbstractFacade<TropaDefensa> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TropaDefensaFacade() {
        super(TropaDefensa.class);
    }
    
}
