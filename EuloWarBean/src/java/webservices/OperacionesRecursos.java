/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.Recurso;
import model.Usuario;
import session.RecursoFacade;
import session.UsuarioFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "OperacionesRecursos")
@Stateless()
public class OperacionesRecursos {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private RecursoFacade recursoFacade;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sumarRecursos")
    public boolean sumarRecursos(@WebParam(name = "unidades") int unidades, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.find(email);
        if (u==null){
            return false;
        }else{
            Collection<Recurso> recursoCollection = u.getRecursoCollection();
            Iterator<Recurso> recursoIterator = recursoCollection.iterator();
            Recurso r = recursoIterator.next();
            System.out.println("UNIDADES: " + r.getUnidades() + " usuario: " + r.getFKUsuario().getEmail());
            int unidadesRecurso = r.getUnidades();
            int unidadesTotales = unidadesRecurso + unidades;
            r.setUnidades(unidadesTotales);
            recursoFacade.edit(r);
            return true;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restarRecursos")
    public String restarRecursos(@WebParam(name = "unidades") int unidades, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.find(email);
        if (u==null){
            return "NO_USUARIO";
        }else{
            Collection<Recurso> recursoCollection = u.getRecursoCollection();
            Iterator<Recurso> recursoIterator = recursoCollection.iterator();
            Recurso r = recursoIterator.next();
            System.out.println("UNIDADES: " + r.getUnidades() + " usuario: " + r.getFKUsuario().getEmail());
            int unidadesRecurso = r.getUnidades();
            int unidadesTotales = unidadesRecurso - unidades;
            if (unidadesTotales < 0){
                return "INSUFICIENTES_RECURSOS";
            }
            r.setUnidades(unidadesTotales);
            recursoFacade.edit(r);
            return "OK";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerRecursos")
    public Integer obtenerRecursos(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.find(email);
        if(u == null){
            return -10;
        }else{
            Collection<Recurso> recursosCollection = u.getRecursoCollection();
            Iterator<Recurso> recursoIterator = recursosCollection.iterator();
            Recurso r = recursoIterator.next();
            int unidadesExistentes = r.getUnidades();
            //System.out.println("Recursos Usuario: " + unidadesExistentes);
            return unidadesExistentes;
        }
        //return null;
    }

}
