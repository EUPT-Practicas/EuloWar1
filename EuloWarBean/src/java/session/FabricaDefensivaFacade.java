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
import model.FabricaDefensiva;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class FabricaDefensivaFacade extends AbstractFacade<FabricaDefensiva> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FabricaDefensivaFacade() {
        super(FabricaDefensiva.class);
    }
    
    public FabricaDefensiva obtenerFabricaFromEmail (String email){
        Query q = em.createNamedQuery("FabricaDefensiva.findAll");
        List<FabricaDefensiva> listaFabricas = q.getResultList();
        for (FabricaDefensiva fabrica : listaFabricas){
            if (fabrica.getFKFabricaDefensivaUsuario().getEmail().equals(email)){
                return fabrica;
            }
        }
        return null;
    }
    
}
