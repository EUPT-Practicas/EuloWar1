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
import model.TropaAtaque;
import model.TropaDefensa;
import session.FabricaDefensivaFacade;
import session.FabricaOfensivaFacade;
import session.TropaAtaqueFacade;
import session.TropaDefensaFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "OperacionesTropas")
@Stateless()
public class OperacionesTropas {
    
    private final int COSTE_MEJORA_FABRICA_NIVEL2 = 500;
    private final int COSTE_MEJORA_FABRICA_NIVEL3 = 1000;
    private final int COSTE_MEJORA_FABRICA_NIVEL4 = 2000;
    private final int COSTE_MEJORA_FABRICA_NIVEL5 = 4000;
    private final int COSTE_MEJORA_FABRICA_NIVEL6 = 8000;
    private final int NIVEL_MAXIMO_FABRICAS = 6;
    private final int NIVEL_MAXIMO_TROPAS = 3;
        
    @EJB
    private FabricaOfensivaFacade fabricaOfensivaFacade;
    @EJB
    private FabricaDefensivaFacade fabricaDefensivaFacade;
    @EJB
    private TropaAtaqueFacade tropaAtaqueFacade;
    @EJB
    private TropaDefensaFacade tropaDefensaFacade;

    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "mejorarFabricaOfensiva")
    public boolean mejorarFabricaOfensiva(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        FabricaOfensiva fabricaOfensiva = fabricaOfensivaFacade.obtenerFabricaFromEmail(email);
        int nivel = fabricaOfensiva.getNivelFabricaOfensiva();
        if (nivel < NIVEL_MAXIMO_FABRICAS){
            fabricaOfensiva.setNivelFabricaOfensiva(nivel+1);
            fabricaOfensivaFacade.edit(fabricaOfensiva);
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     * @param email
     * @return 
     */
    @WebMethod(operationName = "mejorarFabricaDefensiva")
    public boolean mejorarFabricaDefensiva(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        FabricaDefensiva fabricaDefensiva = fabricaDefensivaFacade.obtenerFabricaFromEmail(email);
        int nivel = fabricaDefensiva.getNivelFabricaDefensiva();
        if (nivel < NIVEL_MAXIMO_FABRICAS){
            fabricaDefensiva.setNivelFabricaDefensiva(nivel+1);
            fabricaDefensivaFacade.edit(fabricaDefensiva);
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     * @param email
     * @param tipo
     * @param unidades
     * @return 
     */
    @WebMethod(operationName = "agregarTropasOfensivas")
    public boolean agregarTropasOfensivas(@WebParam(name = "email") String email, @WebParam(name = "tipo") String tipo, @WebParam(name = "unidades") int unidades) {
        //TODO write your implementation code here:
        TropaAtaque tropaAtaque = tropaAtaqueFacade.obtenerTropasFromEmailAndTipo(email, tipo);
        int unidadesActuales = tropaAtaque.getUnidades();
        tropaAtaque.setUnidades(unidades+unidadesActuales);
        tropaAtaqueFacade.edit(tropaAtaque);
        return true;
    }
    
    @WebMethod(operationName = "agregarTropasDefensivas")
    public boolean agregarTropasDefensivas(@WebParam(name = "email") String email, @WebParam(name = "tipo") String tipo, @WebParam(name = "unidades") int unidades) {
        //TODO write your implementation code here:
        TropaDefensa tropaDefensa = tropaDefensaFacade.obtenerTropasFromEmailAndTipo(email, tipo);
        int unidadesActuales = tropaDefensa.getUnidades();
        tropaDefensa.setUnidades(unidades+unidadesActuales);
        tropaDefensaFacade.edit(tropaDefensa);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mejorarTropaOfensiva")
    public boolean mejorarTropaOfensiva(@WebParam(name = "email") String email, @WebParam(name = "tipo") String tipo) {
        //TODO write your implementation code here:
        TropaAtaque tropaAtaque = tropaAtaqueFacade.obtenerTropasFromEmailAndTipo(email, tipo);
        int nivel = tropaAtaque.getNivelTropaAtaque();
        if (nivel < NIVEL_MAXIMO_TROPAS){
            tropaAtaque.setNivelTropaAtaque(nivel+1);
            tropaAtaqueFacade.edit(tropaAtaque);
            return true;
        }
        return false;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "mejorarTropaDefensiva")
    public boolean mejorarTropaDefensiva(@WebParam(name = "email") String email, @WebParam(name = "tipo") String tipo) {
        //TODO write your implementation code here:
        TropaDefensa tropaDefensa = tropaDefensaFacade.obtenerTropasFromEmailAndTipo(email, tipo);
        int nivel = tropaDefensa.getNivelTropaDefensa();
        if (nivel < NIVEL_MAXIMO_TROPAS){
            tropaDefensa.setNivelTropaDefensa(nivel+1);
            tropaDefensaFacade.edit(tropaDefensa);
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTropaAtaque")
    public TropaAtaque getTropaAtaque(@WebParam(name = "emailUsuario") String emailUsuario, @WebParam(name = "tipoTropa") String tipoTropa) {
        //TODO write your implementation code here
        
        return tropaAtaqueFacade.obtenerTropasFromEmailAndTipo(emailUsuario, tipoTropa);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTropaDefensa")
    public TropaDefensa getTropaDefensa(@WebParam(name = "emailUsuario") String emailUsuario, @WebParam(name = "tipoTropa") String tipoTropa) {
        //TODO write your implementation code here:
        return tropaDefensaFacade.obtenerTropasFromEmailAndTipo(emailUsuario, tipoTropa);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNivelFabricaAtaque")
    public Integer getNivelFabricaAtaque(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        return fabricaOfensivaFacade.obtenerFabricaFromEmail(emailUsuario).getNivelFabricaOfensiva();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNivelFabricaDefensa")
    public Integer getNivelFabricaDefensa(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        return fabricaDefensivaFacade.obtenerFabricaFromEmail(emailUsuario).getNivelFabricaDefensiva();
    }
    
    
}
