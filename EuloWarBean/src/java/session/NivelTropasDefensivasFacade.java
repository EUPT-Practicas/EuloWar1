/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    public List<String> getNombresTropas() {
        Query q = em.createNamedQuery("NivelTropasDefensivas.findAll");
        List<String> tiposTropas = new ArrayList<>();
        List<NivelTropasDefensivas> listDefensivas = q.getResultList();
        for (NivelTropasDefensivas elementoDefensivo : listDefensivas) {
            if (!tiposTropas.contains(elementoDefensivo.getTipoTropa())) {
                tiposTropas.add(elementoDefensivo.getTipoTropa());
            }
        }
        return tiposTropas;
    }
    
}
