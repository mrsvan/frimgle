package mobi.nuuvo.frimgle.server.player.config.elements;

import javax.xml.bind.annotation.*;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkElement {
    @XmlAttribute
    String target;
    @XmlValue
    String value;

    public LinkElement() {
    }

    public LinkElement(String target, String value) {
        this.target = target;
        this.value = value;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
