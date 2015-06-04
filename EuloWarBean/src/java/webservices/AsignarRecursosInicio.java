/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.FabricaDefensiva;
import model.FabricaOfensiva;
import model.Recurso;
import model.TropaAtaque;
import model.TropaDefensa;
import model.Usuario;
import session.FabricaDefensivaFacade;
import session.FabricaOfensivaFacade;
import session.MinaFacade;
import session.NivelTropasDefensivasFacade;
import session.NivelTropasOfensivasFacade;
import session.RecursoFacade;
import session.TropaAtaqueFacade;
import session.TropaDefensaFacade;
import session.UsuarioFacade;

/**
 *
 * @author Sergio
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
    @EJB
    private FabricaOfensivaFacade fabricaOfensivaFacade;
    @EJB
    private FabricaDefensivaFacade fabricaDefensivaFacade;
    @EJB
    private TropaAtaqueFacade tropaAtaqueFacade;
    @EJB
    private TropaDefensaFacade tropaDefensaFacade;
    @EJB
    private NivelTropasDefensivasFacade nivelTropasDefensivasFacade;
    @EJB
    private NivelTropasOfensivasFacade nivelTropasOfensivasFacade;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "asignarRecursos")
    public boolean asignarRecursos(@WebParam(name = "emailUsuario") String email) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(email);
        Recurso r = new Recurso("HIERRO", 1000);
        r.setFKUsuario(u);
        recursoFacade.create(r);
        return true;
    }
    
    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "asignarFabricasTropas")
    public boolean asignarFabricasTropas(@WebParam(name = "emailUsuario") String email) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(email);
        FabricaOfensiva fo = new FabricaOfensiva(1);
        FabricaDefensiva fd = new FabricaDefensiva(1);
        fo.setFKFabricaOfensivaUsuario(u);
        fd.setFKFabricaDefensivaUsuario(u);
        
        fabricaOfensivaFacade.create(fo);
        fabricaDefensivaFacade.create(fd);
        
        List<String> tiposTropasDefensivas = nivelTropasDefensivasFacade.getNombresTropas();
        List<String> tiposTropasOfensivas = nivelTropasOfensivasFacade.getNombresTropas();
        for (String tipoTropaOfensiva : tiposTropasOfensivas){
            TropaAtaque ta = new TropaAtaque(tipoTropaOfensiva, 0);
            ta.setNivelTropaAtaque(1);
            ta.setFKTropaAtaqueUsuario(u);
            ta.setFKTropaAtaqueFabricaOfensiva(fo);
            tropaAtaqueFacade.create(ta);
        }
        for (String tipoTropaDefensiva : tiposTropasDefensivas){
            TropaDefensa td = new TropaDefensa(tipoTropaDefensiva, 0);
            td.setNivelTropaDefensa(1);
            td.setFKTropaDefensaUsuario(u);
            td.setFKTropaDefensaFabricaDefensiva(fd);
            tropaDefensaFacade.create(td);
        }
        
        
        return true;
    }

    /**
     * Web service operation
     * @param email
     * @return 
     */
//    @WebMethod(operationName = "asignarTropas")
//    public boolean asignarTropas(@WebParam(name = "emailUsuario") String email) {
//        //TODO write your implementation code here:
//        Usuario u = usuarioFacade.findByEmail(email);
//        
//        u.
//        
//        List<String> tiposTropasDefensivas = nivelTropasDefensivasFacade.getNombresTropas();
//        List<String> tiposTropasOfensivas = nivelTropasOfensivasFacade.getNombresTropas();
//        for (String tipoTropaOfensiva : tiposTropasOfensivas){
//            TropaAtaque ta = new TropaAtaque(tipoTropaOfensiva, 0);
//            ta.setFKTropaAtaqueUsuario(u);
//            tropaAtaqueFacade.create(ta);
//        }
//        for (String tipoTropaDefensiva : tiposTropasDefensivas){
//            TropaDefensa td = new TropaDefensa(tipoTropaDefensiva, 0);
//            td.setFKTropaDefensaUsuario(u);
//            tropaDefensaFacade.create(td);
//        }
//        
//        
//        return true;
//    }
}
