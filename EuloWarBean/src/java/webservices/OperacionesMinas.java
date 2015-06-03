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
import model.Mina;
import model.NivelMina;
import model.Recurso;
import model.Usuario;
import session.MinaFacade;
import session.NivelMinaFacade;
import session.RecursoFacade;
import session.UsuarioFacade;

/**
 *
 * @author Sergio
 */
@WebService(serviceName = "OperacionesMinas")
@Stateless()
public class OperacionesMinas {

    @EJB
    private MinaFacade minaFacade;
    @EJB
    private NivelMinaFacade nivelMinaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private RecursoFacade recursoFacade;

    private static final int NIVEL_MAXIMO = 5;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "producirRecursos")
    public synchronized boolean producirRecursos(@WebParam(name = "idMina") int idMina) {

        Mina m = (Mina) minaFacade.find(idMina);
//        System.out.println("IDMINA: "+idMina);
        int nivel = m.getNivelMina();
//        System.err.println("NIVEL DE LA MINA: " +nivel);
        NivelMina nm = nivelMinaFacade.find(nivel);
//        System.out.println("GANANCIA: " + nm.getGanancia());
        String email = m.getFKMinaUsuario().getEmail();
        Recurso r = recursoFacade.obtenerRecursosFromEmail(email);
//        Recurso r = m.getFKMinaRecurso();
        r.setUnidades(r.getUnidades() + nm.getGanancia());
//        m.setDeposito(m.getDeposito() + nm.getGanancia());
        minaFacade.edit(m);

        return true;
    }

    /**
     * Web service operation
     *
     * @param idMina
     * @return
     */
    @WebMethod(operationName = "mejorarMina")
    public boolean mejorarMina(@WebParam(name = "idMina") int idMina) {
        //TODO write your implementation code here:
        Mina m = (Mina) minaFacade.find(idMina);
        System.err.println("MINA: " + m.getIdMina());
        int nivel = m.getNivelMina();
        if (nivel <= NIVEL_MAXIMO) {
            m.setNivelMina(nivel + 1);
            minaFacade.edit(m);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "asignarMina")
    public Mina asignarMina(@WebParam(name = "emailUsuario") String emailUsuario) {
        //TODO write your implementation code here:
        Usuario u = usuarioFacade.findByEmail(emailUsuario);
        Mina m = new Mina("HIERRO", 1);
        m.setFKMinaUsuario(u);
        minaFacade.create(m);
        return m;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerMinas")
    public List obtenerMinas(@WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Usuario u = (Usuario) usuarioFacade.findByEmail(email);
        if (u != null) {
            return minaFacade.obtenerMinasFromEmail(email);
//            List<Mina> minas = minaFacade.findAll();
//            List<Mina> listaMinas = new LinkedList<>();
//            for (Mina m : minas) {
//                System.out.println("Mina: " + m.getIdMina() + " | Usuario: " + m.getFKMinaUsuario().getEmail());
//                System.out.println("Lista ret: " + listaMinas.size());
//                if (m.getFKMinaUsuario().getEmail().equals(u.getEmail())) {
//                    System.out.println("Añade mina: " + m.getIdMina());
//                    listaMinas.add(m);
//                }
//            }
//            return listaMinas;
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerNivelMina")
    public NivelMina obtenerNivelMina(@WebParam(name = "nivelMina") int nivelMina) {
        NivelMina nm = nivelMinaFacade.find(nivelMina);
        //System.out.println("Nivel mina: " + nm.getNivel() + " , " + nm.getGanancia());
        return nm;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMina")
    public Mina getMina(@WebParam(name = "idMina") int idMina) {
        List<Mina> listaMinas = minaFacade.findAll();
        for(Mina m : listaMinas){
            if(m.getIdMina().equals(idMina)){
                return m;
            }
        }
        return null;
    }
}
