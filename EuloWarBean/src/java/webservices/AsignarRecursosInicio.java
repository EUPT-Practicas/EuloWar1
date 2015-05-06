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
import model.Mina;
import model.Recurso;
import model.Usuario;
import session.MinaFacade;
import session.RecursoFacade;
import session.UsuarioFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "AsignarRecursosInicio")
@Stateless()
public class AsignarRecursosInicio {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private MinaFacade minaFacade;
    @EJB
    private RecursoFacade recursoFacade;

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "asignarMina")
    public boolean asignarMina(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(emailUsuario);
        Mina m = new Mina ("HIERRO", 1);
        m.setFKMinaUsuario(u);
        minaFacade.create(m);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "asignarRecursos")
    public boolean asignarRecursos(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(email);
        Recurso r = new Recurso("HIERRO", 1000);
        r.setFKUsuario(u);
        recursoFacade.create(r);
        return true;
    }
    
    
}
