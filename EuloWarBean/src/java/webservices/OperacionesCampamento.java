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
    @WebMethod(operationName = "nuevoCampamento")
    public Boolean nuevoCampamento(@WebParam(name = "emailUsuario") String emailUsuario) {
        Usuario usuario = usuarioFacade.findByEmail(emailUsuario);
        Campamento campamento = new Campamento(); //Creo que falta el id del campamento
        campamento.setFKCampamentoUsuario(usuario);
        campamentoFacade.create(campamento);
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerCampamentos")
    public List obtenerCampamentos(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        Usuario usuario = (Usuario) usuarioFacade.findByEmail(emailUsuario);
        if (usuario != null) {
            return  campamentoFacade.obtenerMinasFromEmail(emailUsuario);
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
     * FALTA OBTENER NIVEL CAMPAMENTO
     */
    
    
    
    
}
