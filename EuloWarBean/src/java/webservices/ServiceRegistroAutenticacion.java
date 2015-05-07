/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import model.Usuario;
import session.UsuarioFacade;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "ServiceRegistroAutenticacion")
@Stateless()
public class ServiceRegistroAutenticacion {

    @EJB
    UsuarioFacade usuarioFacade;

    /**
     * Web service operation
     *
     * @param email
     * @param nombreUsuario
     * @param password
     * @return
     */
    @WebMethod(operationName = "crearUsuario")
    public boolean crearUsuario(@WebParam(name = "email") String email, @WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Usuario u = new Usuario(email, nombreUsuario, password);
        if (usuarioFacade.find(email) != null) {
            System.out.println("existe");
            return false;
        }
        System.out.println("no existe");
        usuarioFacade.create(u);
        return true;
    }

    /**
     * Web service operation
     *
     * @param nomUsuario
     * @return
     */
    @WebMethod(operationName = "findUser")
    public Usuario findUser(@WebParam(name = "nomUsuario") String nomUsuario) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByNombreUsuario(nomUsuario);
        return u;
    }

    /**
     * Web service operation
     *
     * @param nombreUsuario
     * @param password
     * @return
     */
    @WebMethod(operationName = "comprobarLogin")
    public boolean comprobarLogin(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
//        Usuario u1;
        System.out.println("nombre ws" + nombreUsuario);
        System.out.println("pass ws= " + password);
        Usuario u1 = usuarioFacade.findByNombreUsuario(nombreUsuario);
        if (u1!=null){
            String passwordU1 = u1.getPassword();
            return passwordU1.equals(password);
        }
        return false;
    }
}
