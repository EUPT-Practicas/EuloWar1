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
import model.NivelTropasOfensivas;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class NivelTropasOfensivasFacade extends AbstractFacade<NivelTropasOfensivas> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelTropasOfensivasFacade() {
        super(NivelTropasOfensivas.class);
    }
    
    public List<String> getNombresTropas() {
        Query q = em.createNamedQuery("NivelTropasOfensivas.findAll");
        List<String> tiposTropas = new ArrayList<>();
        List<NivelTropasOfensivas> listOfensivas = q.getResultList();
        for (NivelTropasOfensivas elementoOfensivo : listOfensivas) {
            if (!tiposTropas.contains(elementoOfensivo.getTipoTropa())) {
                tiposTropas.add(elementoOfensivo.getTipoTropa());
            }
        }
        return tiposTropas;
    }
    
}
