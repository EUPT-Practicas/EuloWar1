
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "eliminarCuenta", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminarCuenta", namespace = "http://webservices/", propOrder = {
    "emailUsuario",
    "password"
})
public class EliminarCuenta {

    @XmlElement(name = "emailUsuario", namespace = "")
    private String emailUsuario;
    @XmlElement(name = "password", namespace = "")
    private String password;

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
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @param password
     *     the value for the password property
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
