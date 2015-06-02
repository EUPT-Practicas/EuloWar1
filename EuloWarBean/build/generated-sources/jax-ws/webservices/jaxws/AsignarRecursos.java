
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "asignarRecursos", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asignarRecursos", namespace = "http://webservices/")
public class AsignarRecursos {

    @XmlElement(name = "emailUsuario", namespace = "")
    private String emailUsuario;

    /**
     * 
     * @return
     *     returns String
     */
    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    /**
     * 
     * @param emailUsuario
     *     the value for the emailUsuario property
     */
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

}
