/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.FabricaDefensiva;
import model.FabricaOfensiva;
import model.TropaAtaque;
import model.TropaDefensa;
import model.Usuario;
import session.FabricaDefensivaFacade;
import session.FabricaOfensivaFacade;
import session.NivelTropasDefensivasFacade;
import session.NivelTropasOfensivasFacade;
import session.TropaAtaqueFacade;
import session.TropaDefensaFacade;
import session.UsuarioFacade;

/**
 *
 * @author FranciscoJavier
 */
@WebService(serviceName = "OperacionesCombates")
@Stateless()
public class OperacionesCombates {
    
    @EJB
    private FabricaDefensivaFacade fabricaDefensivaFacade;
    @EJB
    private FabricaOfensivaFacade fabricaOfensivaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB 
    private TropaAtaqueFacade tropaAtaqueFacade;
    @EJB
    private TropaDefensaFacade tropaDefensaFacade;
    @EJB 
    private NivelTropasOfensivasFacade nivelTropasOfensivasFacade;
    @EJB 
    private NivelTropasDefensivasFacade nivelTropasDefensivasFacade;
    
    private Random random = new Random();
    
    private final String A_TANQUE = "TANQUE";
    private final int FUERZA_A_TANQUE = 20;
    private final String A_PELOTON = "PELOTON";
    private final int FUERZA_A_PELOTON = 5;
    private final String A_AVION_COMBATE = "AVION_COMBATE";
    private final int FUERZA_A_AVION_COMBATE = 80;
    private final String A_VEHICULO_BLINDADO = "VEHICULO_BLINDADO";
    private final int FUERZA_A_VEHICULO_BLINDADO = 10;
    private final String A_HELICOPTERO = "HELICOPTERO";
    private final int FUERZA_A_HELICOPTERO = 40;
    private final String A_CHUCK_NORRIS = "CHUCK_NORRIS";
    private final int FUERZA_A_CHUNK_NORRIS = 160;
    
    private final String D_MISIL_ANTIAEREO = "MISIL_ANTIAEREO";
    private final int FUERZA_D_MISIL_ANTIAEREO = 80;
    private final String D_TRINCHERA_AMETRALLADORAS = "TRINCHERA_AMETRALLADORAS";
    private final int FUERZA_D_TRINCHERA_AMETRALLADORAS = 10;
    private final String D_RAMBO = "RAMBO";
    private final int FUERZA_D_RAMBO = 160;
    private final String D_CAMPO_MINAS = "CAMPO_MINAS";
    private final int FUERZA_D_CAMPO_MINAS = 5;
    private final String D_CANYON_COMBATE = "CAÑON_COMBATE";
    private final int FUERZA_D_CANYON_COMBATE = 20;
    private final String D_CANYON_ANTIAEREO = "CAÑON_ANTIAEREO";
    private final int FUERZA_D_CANYON_ANTIAEREO = 40;
    
    

    /**
     * Elige un rival para un ataque en funcion de los niveles de fabrica ofensiva
     * y defensiva.
     * @param email
     * @return 
     */
    @WebMethod(operationName = "elegirRival")
    public Usuario elegirRival(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        FabricaOfensiva fabricaOfensivaUsuario;
        FabricaDefensiva fabricaRival;
                
        fabricaOfensivaUsuario = fabricaOfensivaFacade.obtenerFabricaFromEmail(email);
        System.out.println("FABRICAOFENSIVA::::" + fabricaOfensivaUsuario);
        int nivelFabrica = fabricaOfensivaUsuario.getNivelFabricaOfensiva();
        
        List<FabricaDefensiva> listaFabricasRivales = fabricaDefensivaFacade.findAll();
        List<FabricaDefensiva> listaFabricasMismoNivel = new ArrayList<>();
        for (FabricaDefensiva fabricaDefensivaRival : listaFabricasRivales){
            if (nivelFabrica == fabricaDefensivaRival.getNivelFabricaDefensiva()){
                listaFabricasMismoNivel.add(fabricaDefensivaRival);
            }
        }
        if (listaFabricasMismoNivel.isEmpty()){
            //ELEGIR UN RIVAL CUALQUIERA.
            int aleatorio = random.nextInt(listaFabricasRivales.size()+1);
            fabricaRival = listaFabricasRivales.get(aleatorio);
        } else {
            //ELEGIR UN RIVAL CUALQUIERA DE ESA LISTA.
            int aleatorioNivel = random.nextInt(listaFabricasMismoNivel.size());
            fabricaRival = listaFabricasMismoNivel.get(aleatorioNivel);
        }
        System.out.println("RIVALISIMO ES: "+ fabricaRival.getFKFabricaDefensivaUsuario().getEmail());
        return fabricaRival.getFKFabricaDefensivaUsuario();

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "simularCombate")
    public Usuario simularCombate(@WebParam(name = "emailAtacante") String emailAtacante, @WebParam(name = "emailDefensor") String emailDefensor) {
        //TODO write your implementation code here:
        int fuerzaAtaqueRival = 0;
        int fuerzaDefensaRival = 0;
        Usuario ganador = null;
        
        List<TropaDefensa> tropasDefensivas = tropaDefensaFacade.obtenerTropasFromEmail(emailDefensor);
        List<TropaAtaque> tropasOfensivas = tropaAtaqueFacade.obtenerTropasFromEmail(emailAtacante);
        
        List<String> tiposOfensivos = nivelTropasOfensivasFacade.getNombresTropas();
        List<String> tiposDefensivos = nivelTropasOfensivasFacade.getNombresTropas();

        for (TropaAtaque tropaAtacante : tropasOfensivas){
            //MULTIPLICAR FUERZA * UNIDADES * NIVEL
            switch (tropaAtacante.getTipoTropaAtaque()){
                case A_AVION_COMBATE:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_AVION_COMBATE;
                    break;
                case A_CHUCK_NORRIS:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_CHUNK_NORRIS;
                    break;
                case A_HELICOPTERO:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_HELICOPTERO;
                    break;
                case A_PELOTON:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_PELOTON;
                    break;
                case A_TANQUE:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_TANQUE;
                    break;
                case A_VEHICULO_BLINDADO:
                    fuerzaAtaqueRival += tropaAtacante.getUnidades()*FUERZA_A_VEHICULO_BLINDADO;
                    break;
                default:
                    break;
            }
        }
        for (TropaDefensa tropaDefensora : tropasDefensivas){
            switch (tropaDefensora.getTipoTropaDefensa()){
                case D_CAMPO_MINAS:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_CAMPO_MINAS;
                    break;
                case D_CANYON_ANTIAEREO:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_CANYON_ANTIAEREO;
                    break;
                case D_CANYON_COMBATE:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_CANYON_COMBATE;
                    break;
                case D_MISIL_ANTIAEREO:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_MISIL_ANTIAEREO;
                    break;
                case D_RAMBO:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_RAMBO;
                    break;
                case D_TRINCHERA_AMETRALLADORAS:
                    fuerzaDefensaRival += tropaDefensora.getUnidades()*FUERZA_D_TRINCHERA_AMETRALLADORAS;
                    break;
                default:
                    break;
            }
        }
        
        double fuerzaAtaqueDefinitiva = 0.0;
        double fuerzaDefensaDefinitiva = 0.0;
        do{
            double numeroAleatorioAtaque = random.nextDouble();
            double numeroAleatorioDefensa = random.nextDouble();
        
            fuerzaAtaqueDefinitiva = numeroAleatorioAtaque*fuerzaAtaqueRival;
            fuerzaDefensaDefinitiva = numeroAleatorioDefensa*fuerzaDefensaRival;
            
            if (fuerzaAtaqueDefinitiva > fuerzaDefensaDefinitiva){
                ganador = usuarioFacade.findByEmail(emailAtacante);
            } else {
                ganador = usuarioFacade.findByEmail(emailDefensor);
            }
        }while(fuerzaAtaqueDefinitiva == fuerzaDefensaDefinitiva);
        System.out.println("FUERZA SIN ALEATORIO DE ARAQUE: " + fuerzaAtaqueRival);
        System.out.println("FUERZA SIN ALEATORIO DE DEFENSA: " + fuerzaDefensaRival);
        
        System.out.println("GANADORRRRRRRR: " + ganador.getEmail());
        return ganador;
    }

    
}
