
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "asignarMinaResponse", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asignarMinaResponse", namespace = "http://webservices/")
public class AsignarMinaResponse {

    @XmlElement(name = "return", namespace = "")
    private model.Mina _return;

    /**
     * 
     * @return
     *     returns Mina
     */
    public model.Mina getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(model.Mina _return) {
        this._return = _return;
    }

}
