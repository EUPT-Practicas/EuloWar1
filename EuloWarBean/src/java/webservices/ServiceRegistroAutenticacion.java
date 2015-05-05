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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearUsuario")
    public boolean crearUsuario(@WebParam(name = "email") String email, @WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Usuario u = new Usuario(email, nombreUsuario, password);
        try{
            usuarioFacade.create(u);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "findUser")
    public Usuario findUser(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(email);
        return u;
    }

    /**
     * Web service operation
     * @param email
     * @param password
     * @return 
     */
    @WebMethod(operationName = "comprobarLogin")
    public boolean comprobarLogin(@WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Usuario u1 = usuarioFacade.findByEmail(email);
        String passwordU1 = u1.getPassword();
        
        return passwordU1.equals(password);
    }
}
