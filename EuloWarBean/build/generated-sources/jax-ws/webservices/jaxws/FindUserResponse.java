
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findUserResponse", namespace = "http://webservices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findUserResponse", namespace = "http://webservices/")
public class FindUserResponse {

    @XmlElement(name = "return", namespace = "")
    private model.Usuario _return;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public model.Usuario getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(model.Usuario _return) {
        this._return = _return;
    }

}
