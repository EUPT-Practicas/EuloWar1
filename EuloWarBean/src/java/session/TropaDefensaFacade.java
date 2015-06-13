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
    
    public TropaDefensa obtenerTropasFromEmailAndTipo(String email, String tipo){
        Query q = em.createNamedQuery("TropaDefensa.findByTipoTropaDefensa");
        q.setParameter("tipoTropaDefensa", tipo);
        List<TropaDefensa> listaTropas = q.getResultList();
        for (TropaDefensa tropa : listaTropas){
            if (tropa.getFKTropaDefensaUsuario().getEmail().equals(email)){
                return tropa;
            }
        }
        return null;
    }
    
    public List<TropaDefensa> obtenerTropasFromEmail(String email){
        Query q = em.createNamedQuery("TropaDefensa.findAll");
        List<TropaDefensa> listaTropas = q.getResultList();
        List<TropaDefensa> listaFinal = new ArrayList<>();
        for (TropaDefensa tropa : listaTropas){
            if (tropa.getFKTropaDefensaUsuario().getEmail().equals(email)){
                listaFinal.add(tropa);
            }
        }
        return listaFinal;
    }
    
}
