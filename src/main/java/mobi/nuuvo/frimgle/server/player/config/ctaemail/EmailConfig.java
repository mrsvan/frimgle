package mobi.nuuvo.frimgle.server.player.config.ctaemail;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAndOther;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "emailfield")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailConfig extends ElementWithXYAndOther {
    @XmlElement
    private String defaultText;

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }
}
