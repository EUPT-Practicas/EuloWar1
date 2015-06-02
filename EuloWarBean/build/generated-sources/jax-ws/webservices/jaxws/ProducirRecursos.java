
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "producirRecursos", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producirRecursos", namespace = "http://webservices/")
public class ProducirRecursos {

    @XmlElement(name = "idMina", namespace = "")
    private int idMina;

    /**
     * 
     * @return
     *     returns int
     */
    public int getIdMina() {
        return this.idMina;
    }

    /**
     * 
     * @param idMina
     *     the value for the idMina property
     */
    public void setIdMina(int idMina) {
        this.idMina = idMina;
    }

}
