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
import model.NivelMina;
import model.Usuario;
import session.MinaFacade;
import session.NivelMinaFacade;
import session.UsuarioFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "ProducirRecursosMina")
@Stateless()
public class OperacionesMinas {

    @EJB
    private MinaFacade minaFacade;
    @EJB
    private NivelMinaFacade nivelMinaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private static final int NIVEL_MAXIMO = 5;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "producirRecursos")
    public boolean producirRecursos(@WebParam(name = "idMina") int idMina) {
        
        Mina m = (Mina) minaFacade.find(idMina);
//        System.out.println("IDMINA: "+idMina);
        int nivel = m.getNivelMina();
//        System.err.println("NIVEL DE LA MINA: " +nivel);
        NivelMina nm = nivelMinaFacade.find(nivel);
//        System.out.println("GANANCIA: " + nm.getGanancia());
        m.setDeposito(m.getDeposito() + nm.getGanancia());
        minaFacade.edit(m);
        
        return true;
    }

    /**
     * Web service operation
     * @param idMina
     * @return 
     */
    @WebMethod(operationName = "mejorarMina")
    public boolean mejorarMina(@WebParam(name = "idMina") int idMina) {
        //TODO write your implementation code here:
        Mina m = (Mina) minaFacade.find(idMina);
        System.err.println("MINA: " + m.getIdMina());
        int nivel = m.getNivelMina();
        if (nivel <= NIVEL_MAXIMO){
            m.setNivelMina(nivel + 1);
            minaFacade.edit(m);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "asignarMina")
    public Mina asignarMina(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(emailUsuario);
        Mina m = new Mina ("HIERRO", 1);
        m.setFKMinaUsuario(u);
        minaFacade.create(m);
        return m;
    }
    
    
}
