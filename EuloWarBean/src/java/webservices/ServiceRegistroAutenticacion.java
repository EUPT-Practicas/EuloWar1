/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.Usuario;
import session.UsuarioFacade;
import utilidades.GestorEmail;

/**
 *
 * @author Sergio
 */
@WebService(serviceName = "ServiceRegistroAutenticacion")
@Stateless()
public class ServiceRegistroAutenticacion {
    
    @EJB
    UsuarioFacade usuarioFacade;

    
    private static final String ASUNTO_NUEVA_CUENTA = "EuloWar - ¡Bienvenido!";

    @WebMethod(operationName = "crearUsuario")
    public boolean crearUsuario(@WebParam(name = "emailUsuario") String email, @WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "passwordUsuario") String password) {
        //TODO write your implementation code here:
        Usuario u = new Usuario(email, nombreUsuario, password);
        if (usuarioFacade.find(email) != null) {
            System.out.println("existe");
            return false;
        }
        System.out.println("no existe");
        usuarioFacade.create(u);
        
        GestorEmail gestorEmail = new GestorEmail();
        String mensaje = "Bienvenido a EuloWar, " + nombreUsuario + ". \n"
                + "Tu cuenta ha sido creada con los siguientes datos:\n\n"
                + "Nombre de usuario: " + nombreUsuario + "\n"
                + "Correo electrónico: " + email + "\n"
                + "Password: ************* \n\n"
                + "Disfruta de la experiencia. Un saludo.";
        gestorEmail.send(email, ASUNTO_NUEVA_CUENTA, mensaje);
        return true;
    }

    /**
     * Web service operation
     *
     * @param nomUsuario
     * @return
     */
    @WebMethod(operationName = "findUser")
    public Usuario findUser(@WebParam(name = "nombreUsuario") String nomUsuario) {
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
    public boolean comprobarLogin(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "passwordUsuario") String password) {
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
    
    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "existeUsuario")
    public boolean existeUsuario(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        
        return usuarioFacade.findByEmail(email) != null;
    }
}
