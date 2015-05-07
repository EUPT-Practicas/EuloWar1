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
import session.MinaFacade;
import session.NivelMinaFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "ProducirRecursosMina")
@Stateless()
public class ProducirRecursosMina {

    @EJB
    private MinaFacade minaFacade;
    @EJB
    private NivelMinaFacade nivelMinaFacade;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "producirRecursos")
    public boolean producirRecursos(@WebParam(name = "idMina") int idMina) {
        
        Mina m = (Mina) minaFacade.find(idMina);
        System.out.println("IDMINA: "+idMina);
        int nivel = m.getNivelMina();
        System.err.println("NIVEL DE LA MINA: " +nivel);
        NivelMina nm = nivelMinaFacade.find(nivel);
        System.out.println("GANANCIA: " + nm.getGanancia());
        m.setDeposito(m.getDeposito() + nm.getGanancia());
        minaFacade.edit(m);
        
        return true;
    }
    
    
}
