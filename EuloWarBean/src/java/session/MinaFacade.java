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

    public List obtenerMinasFromEmail(String email) {
        Query q = em.createNamedQuery("Mina.findAll");

        List<Mina> minas = q.getResultList();
        List<Mina> listaMinas = new LinkedList<>();
        for (Mina m : minas) {
            System.out.println("Mina: " + m.getIdMina() + " | Usuario: " + m.getFKMinaUsuario().getEmail());
            System.out.println("Lista ret: " + listaMinas.size());
            if (m.getFKMinaUsuario().getEmail().equals(email)) {
                System.out.println("Añade mina: " + m.getIdMina());
                listaMinas.add(m);
            }
        }
        return listaMinas;
    }

    /*
     public Recurso obtenerRecursosFromEmail(String email){
     Query q = em.createNamedQuery("Recurso.findAll");
     //q.setParameter("email", email);
     List<Recurso> listaRecursos = q.getResultList();
     for (Recurso r : listaRecursos){
     System.out.println("USUARIORECURSOS: " + r.getFKUsuario().getEmail());
     if (r.getFKUsuario().getEmail().equals(email)){
     return r;
     }
     }
     return null;
     }  
     */
}
