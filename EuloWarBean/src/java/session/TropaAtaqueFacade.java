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
import model.TropaAtaque;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class TropaAtaqueFacade extends AbstractFacade<TropaAtaque> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TropaAtaqueFacade() {
        super(TropaAtaque.class);
    }
    
    public TropaAtaque obtenerTropasFromEmailAndTipo(String email, String tipo){
        Query q = em.createNamedQuery("TropaAtaque.findByTipoTropaAtaque");
        q.setParameter("tipoTropaAtaque", tipo);
        List<TropaAtaque> listaTropas = q.getResultList();
        for (TropaAtaque tropa : listaTropas){
            if (tropa.getFKTropaAtaqueUsuario().getEmail().equals(email)){
                return tropa;
            }
        }
        return null;
    }
    
    public List<TropaAtaque> obtenerTropasFromEmail(String email){
        Query q = em.createNamedQuery("TropaAtaque.findAll");
        List<TropaAtaque> listaTropas = q.getResultList();
        List<TropaAtaque> listaFinal = new ArrayList<>();
        for (TropaAtaque tropa : listaTropas){
            if (tropa.getFKTropaAtaqueUsuario().getEmail().equals(email)){
                listaFinal.add(tropa);
            }
        }
        return listaFinal;
    }
    
}
