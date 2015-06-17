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
import model.Campamento;
import model.Usuario;
import session.CampamentoFacade;
import session.UsuarioFacade;

/**
 *
 * @author Ricardo
 */
@WebService(serviceName = "OperacionesCampamento")
@Stateless()
public class OperacionesCampamento {
    @EJB
    private CampamentoFacade campamentoFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private final int TOTAL_TROPAS_CAMPAMENTO = 250;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevoCampamento")
    public Boolean nuevoCampamento(@WebParam(name = "emailUsuario") String emailUsuario) {
        Usuario usuario = usuarioFacade.findByEmail(emailUsuario);
        Campamento campamento = new Campamento(); //Creo que falta el id del campamento
        campamento.setFKCampamentoUsuario(usuario);
        campamento.setTotal(TOTAL_TROPAS_CAMPAMENTO);
        campamento.setTropasAlmacenadas(0);
        campamentoFacade.create(campamento);
        return true;
    }

    /**
     * Web service operation
     * @param emailUsuario
     * @return 
     */
    @WebMethod(operationName = "obtenerCampamentos")
    public List<Campamento> obtenerCampamentos(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        Usuario usuario = (Usuario) usuarioFacade.findByEmail(emailUsuario);
        if (usuario != null) {
            return  campamentoFacade.obtenerCampamentosFromEmail(emailUsuario);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCampamento")
    public Campamento getCampamento(@WebParam(name = "idCampamento") int idCampamento) {
        List<Campamento> listaCampamentos = campamentoFacade.findAll();
        
        for(Campamento c : listaCampamentos){
            if(c.getIdCampamento().equals(idCampamento)){
                return c;
            }
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarTropasCampamento")
    public String agregarTropasCampamento(@WebParam(name = "posicionesOcupadas") int posicionesOcupadas, @WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        List<Campamento> listaCampamentos = campamentoFacade.obtenerCampamentosFromEmail(emailUsuario);
        int capacidadTotal = 0;
        int capacidadOcupada = 0;
        for (Campamento campamento : listaCampamentos){
            capacidadTotal += campamento.getTotal();
            capacidadOcupada += campamento.getTropasAlmacenadas();
        }
        
        int capacidadRelativa = capacidadTotal - capacidadOcupada;
        
        if (posicionesOcupadas <= capacidadRelativa){
            //caben las troaps en los campamentos
            for (Campamento campamento : listaCampamentos){
                System.out.println("DEVOLVIENDO CAMPAMENTO : " + campamento.getIdCampamento());
                if (campamento.getTotal() != campamento.getTropasAlmacenadas()){
                    System.out.println("CAMPAMENTO TOTAL DISTINTO DE ALMACENADO.");
                    //SI NO ESTA A TOPE METEMOS TROPAS
                    ///TERMIANR
                    capacidadOcupada = campamento.getTropasAlmacenadas();
                    capacidadTotal = campamento.getTotal();
                    capacidadRelativa = capacidadTotal - capacidadOcupada;
                    System.out.println("CAPACIDAD RELATIVA: " + capacidadRelativa);
                    System.out.println("POSICIONES OCUPADAS: " + posicionesOcupadas);
                    System.out.println("CAPACIDAD OCUPADA: " + capacidadOcupada);
                    //int restoTropas = posicionesOcupadas - capacidadTotal;
                    
                    if (capacidadRelativa < posicionesOcupadas){
                        System.out.println("TROPAS NO CABEN EN ESTE CAMPAMENTO");
                        //NO CABEN EN EL CAMPAMENTO ACTUAL.
                        campamento.setTropasAlmacenadas(capacidadTotal);
                        campamentoFacade.edit(campamento);
                        posicionesOcupadas -= capacidadRelativa;
                        if (posicionesOcupadas == 0){
                            return "OK";
                        }
                    } else if (capacidadRelativa >= posicionesOcupadas){
                        System.out.println("TROPAS SI CABEN EN ESTE CAMPAMENTO");
                        //CABEN EN EL CAMPAMENTO ACTUAL
                        campamento.setTropasAlmacenadas(capacidadOcupada+posicionesOcupadas);
                        campamentoFacade.edit(campamento);
                        return "OK";
                    }
                } else {
                    System.out.println("TOTAL CAMPAMENTO IGUAL A TROPAS ALMACENADAS, CAMPAMENTO LLENO");
                }
            }
        } else {
            //no caben las tropas
            return "NO_ESPACIO";
        }
        
        return "ERROR";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "reiniciarCampamentos")
    public boolean reiniciarCampamentos(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        List<Campamento> listaCampamentos = campamentoFacade.obtenerCampamentosFromEmail(emailUsuario);
        for (Campamento campamento : listaCampamentos){
            campamento.setTropasAlmacenadas(0);
        }
        return true;
    }
    
    
    
    
    
    
}
