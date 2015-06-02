
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findUser", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findUser", namespace = "http://webservices/")
public class FindUser {

    @XmlElement(name = "nombreUsuario", namespace = "")
    private String nombreUsuario;

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

}
