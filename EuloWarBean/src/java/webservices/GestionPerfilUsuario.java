/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.Random;
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
@WebService(serviceName = "GestionPerfilUsuario")
@Stateless()
public class GestionPerfilUsuario {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    /*
    METODOS:
    
    - cambiarPassword OOOKK
    - restablecerPassword  OOOOK
    - borrarCuenta???  OOOOKK
    
    */
    
    private static final String ASUNTO_CAMBIO_CONTRASENA = "EuloWar - Restablecer contraseña";
    private static final String ASUNTO_CUENTA_ELIMINADA = "EuloWar - Cuenta eliminada";

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
    @WebMethod(operationName = "cambiarPassword")
    public Boolean cambiarPassword(@WebParam(name = "emailUsuario") String email, 
            @WebParam(name = "viejaPassword") String viejaPassword, 
            @WebParam(name = "nuevaPassword") String nuevaPassword, 
            @WebParam(name = "repiteNuevaPassword") String repiteNuevaPassword) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.findByEmail(email);
        if(u.getPassword().equals(viejaPassword) 
                && nuevaPassword.equals(repiteNuevaPassword)){
            //Cambio de pass
            u.setPassword(nuevaPassword);
            usuarioFacade.edit(u);
            return true;
        }
        return false;
    }
    
      /**
   * private String generarContrasena()
   * 
   * Genera aleatoriamente una contrasena de 8 dígitos de entre mayúsculas,
   *  minúsculas y números
   * 
   * @return la contrasena generada
   */
  private String generarContrasena() { 
    Random random = new Random();
    String caracteres = "0123456789abcdefghijklmnopqrstuvwxyz"
                      + "ABCDEFGHIJKLMNOPQRSTUVWXYZ@";
    String contrasena = "";
    
    for (int i=0; i<8; i++) {
      contrasena += caracteres.charAt(random.nextInt(61));
    }
    return contrasena;
  }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restablecerPassword")
    public Boolean restablecerPassword(@WebParam(name = "emailUsuario") String email) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.findByEmail(email);
        if(u == null){
            return false;
        }
        String nuevaPassword = generarContrasena();
        //System.out.println("new pass: " +nuevaPassword);
        u.setPassword(nuevaPassword);
        GestorEmail gestorEmail = new GestorEmail();
        String mensaje = "Has solicitado restablecer la contraseña de tu cuenta en EuloWar. "
                + "La nueva contraseña es \"" +
              nuevaPassword + "\" . Es recomendable que la cambies cuanto antes";
        gestorEmail.send(email, ASUNTO_CAMBIO_CONTRASENA, mensaje);
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarCuenta")
    public Boolean eliminarCuenta(@WebParam(name = "emailUsuario") String email, 
            @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.findByEmail(email);
        if(u == null){
            return false;
        }else if(!u.getPassword().equals(password)){
            return false;
        }
        usuarioFacade.remove(u);
        GestorEmail gestorEmail = new GestorEmail();
        String mensaje = "Has solicitado eliminar tu cuenta en EuloWar. Tu cuenta ha sido eliminada.";
        gestorEmail.send(email, ASUNTO_CUENTA_ELIMINADA, mensaje);
        return true;
    }
}
