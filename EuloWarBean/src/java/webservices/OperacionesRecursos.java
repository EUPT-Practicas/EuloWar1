/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
        if (u == null) {
            return false;
        } else {
//            Collection<Recurso> recursoCollection = u.getRecursoCollection();
//            Iterator<Recurso> recursoIterator = recursoCollection.iterator();
//            Recurso r = recursoIterator.next();
//            System.out.println("UNIDADES: " + r.getUnidades() + " usuario: " + r.getFKUsuario().getEmail());
            Recurso r = (Recurso) recursoFacade.obtenerRecursosFromEmail(email);
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
        if (u == null) {
            return "NO_USUARIO";
        } else {
//            Collection<Recurso> recursoCollection = u.getRecursoCollection();
//            Iterator<Recurso> recursoIterator = recursoCollection.iterator();
//            Recurso r = recursoIterator.next();
//            System.out.println("UNIDADES: " + r.getUnidades() + " usuario: " + r.getFKUsuario().getEmail());
            Recurso r = (Recurso) recursoFacade.obtenerRecursosFromEmail(email);
            int unidadesRecurso = r.getUnidades();
            int unidadesTotales = unidadesRecurso - unidades;
            if (unidadesTotales < 0) {
                return "INSUFICIENTES_RECURSOS";
            }
            r.setUnidades(unidadesTotales);
            recursoFacade.edit(r);
            return "OK";
        }
    }

    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "obtenerRecursos")
    public Integer obtenerRecursos(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        
        Recurso r = (Recurso) recursoFacade.obtenerRecursosFromEmail(email);
        System.out.println("recursos: " + r.getUnidades());
        System.out.println("tipo: " + r.getTipoRecurso());
        System.out.println("de: " + r.getFKUsuario().getNombreUsuario());
        if (r!=null){
            return r.getUnidades();
        } else {
            return -1;
        }
        
//        Usuario u = (Usuario) usuarioFacade.find(email);
//        System.out.println("usuarioOBTENERECURSOS: " + u.getNombreUsuario());
//        if (u == null) {
//            System.out.println("NULLNULL OBTENER RECURSOS");
//            return -10;
//        } else {
//            System.out.println("existe el usurio obtener recursos");
//            Collection<Recurso> recursosCollection = u.getRecursoCollection();
//            if (u.getRecursoCollection().isEmpty()){
//                System.out.println("TU LISTA DE M.... ESTA VACIA");
//            }
//            List listaRecursos = new ArrayList(recursosCollection);
//            System.out.println("SIZE: " + listaRecursos.size());
//            if (listaRecursos.isEmpty()){
//                System.out.println("ESTA VACIA COÑEEE");
//            }
//            Recurso r = (Recurso) listaRecursos.get(0);
//            System.out.println("RECURSO: " + r.getTipoRecurso());
//            return r.getUnidades();
           
//        }
        //return null;
    }

}
