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
import model.FabricaOfensiva;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class FabricaOfensivaFacade extends AbstractFacade<FabricaOfensiva> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FabricaOfensivaFacade() {
        super(FabricaOfensiva.class);
    }
    
    public FabricaOfensiva obtenerFabricaFromEmail (String email){
        Query q = em.createNamedQuery("FabricaOfensiva.findAll");
        List<FabricaOfensiva> listaFabricas = q.getResultList();
        for (FabricaOfensiva fabrica : listaFabricas){
            if (fabrica.getFKFabricaOfensivaUsuario().getEmail().equals(email)){
                return fabrica;
            }
        }
        return null;
    }
    
}
