
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerNivelMina", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerNivelMina", namespace = "http://webservices/")
public class ObtenerNivelMina {

    @XmlElement(name = "nivelMina", namespace = "")
    private int nivelMina;

    /**
     * 
     * @return
     *     returns int
     */
    public int getNivelMina() {
        return this.nivelMina;
    }

    /**
     * 
     * @param nivelMina
     *     the value for the nivelMina property
     */
    public void setNivelMina(int nivelMina) {
        this.nivelMina = nivelMina;
    }

}
