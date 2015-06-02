
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "crearUsuario", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearUsuario", namespace = "http://webservices/", propOrder = {
    "emailUsuario",
    "nombreUsuario",
    "passwordUsuario"
})
public class CrearUsuario {

    @XmlElement(name = "emailUsuario", namespace = "")
    private String emailUsuario;
    @XmlElement(name = "nombreUsuario", namespace = "")
    private String nombreUsuario;
    @XmlElement(name = "passwordUsuario", namespace = "")
    private String passwordUsuario;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    /**
     * 
     * @param nombreUsuario
     *     the value for the nombreUsuario property
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPasswordUsuario() {
        return this.passwordUsuario;
    }

    /**
     * 
     * @param passwordUsuario
     *     the value for the passwordUsuario property
     */
    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

}
