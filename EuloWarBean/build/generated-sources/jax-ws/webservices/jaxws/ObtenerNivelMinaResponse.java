
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerNivelMinaResponse", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerNivelMinaResponse", namespace = "http://webservices/")
public class ObtenerNivelMinaResponse {

    @XmlElement(name = "return", namespace = "")
    private model.NivelMina _return;

    /**
     * 
     * @return
     *     returns NivelMina
     */
    public model.NivelMina getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(model.NivelMina _return) {
        this._return = _return;
    }

}
