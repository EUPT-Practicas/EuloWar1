/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Campamento;

/**
 *
 * @author FranciscoJavier
 */
@Stateless
public class CampamentoFacade extends AbstractFacade<Campamento> {
    @PersistenceContext(unitName = "EuloWarBeanPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampamentoFacade() {
        super(Campamento.class);
    }
     public List obtenerMinasFromEmail(String emailUsuario) {
        Query q = em.createNamedQuery("Campamento.findAll");

        List<Campamento> campamentos = q.getResultList();
        List<Campamento> listaCampamentos = new LinkedList<>();
        for (Campamento c : campamentos) {
            System.out.println("Campamento " + c.getIdCampamento() + " | Usuario: " + c.getFKCampamentoUsuario().getEmail());
            System.out.println("Lista restante: " + listaCampamentos.size());
            
            if (c.getFKCampamentoUsuario().getEmail().equals(emailUsuario)){
                System.out.println("Añade mina: " + c.getIdCampamento());
                listaCampamentos.add(c);
            }
        }
        return listaCampamentos;
    }
}
