/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.NivelTropasDefensivas;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class NivelTropasDefensivasFacade extends AbstractFacade<NivelTropasDefensivas> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelTropasDefensivasFacade() {
        super(NivelTropasDefensivas.class);
    }
    
}
