
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cambiarPassword", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cambiarPassword", namespace = "http://webservices/", propOrder = {
    "emailUsuario",
    "viejaPassword",
    "nuevaPassword",
    "repiteNuevaPassword"
})
public class CambiarPassword {

    @XmlElement(name = "emailUsuario", namespace = "")
    private String emailUsuario;
    @XmlElement(name = "viejaPassword", namespace = "")
    private String viejaPassword;
    @XmlElement(name = "nuevaPassword", namespace = "")
    private String nuevaPassword;
    @XmlElement(name = "repiteNuevaPassword", namespace = "")
    private String repiteNuevaPassword;

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
    public String getViejaPassword() {
        return this.viejaPassword;
    }

    /**
     * 
     * @param viejaPassword
     *     the value for the viejaPassword property
     */
    public void setViejaPassword(String viejaPassword) {
        this.viejaPassword = viejaPassword;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNuevaPassword() {
        return this.nuevaPassword;
    }

    /**
     * 
     * @param nuevaPassword
     *     the value for the nuevaPassword property
     */
    public void setNuevaPassword(String nuevaPassword) {
        this.nuevaPassword = nuevaPassword;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getRepiteNuevaPassword() {
        return this.repiteNuevaPassword;
    }

    /**
     * 
     * @param repiteNuevaPassword
     *     the value for the repiteNuevaPassword property
     */
    public void setRepiteNuevaPassword(String repiteNuevaPassword) {
        this.repiteNuevaPassword = repiteNuevaPassword;
    }

}
