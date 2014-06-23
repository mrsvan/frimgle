package mobi.nuuvo.frimgle.server.player.config.ctashare;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrSourceAndLinkElements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {@code
 * <CTAShare>
 * <button x="145" y="128">
 * <!-- BUTTON SHARE -->
 * <source>img/fb-btn-share.png</source>
 * <!--
 * //<link target="_blank">https://www.google.com</link>LINK WHEN CLICKING ON THE BUTTON// REMOVED, AUTOMATED TO SIMPLIFY DEPLOYMENT//
 * -->
 * </button>
 * </CTAShare>
 * }
 * Created by svd on 6/18/14.
 */
@XmlRootElement(name = "CTAShare")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTAShareConfig {
    @XmlElement(name = "button")
    private ElementWithXYAttrSourceAndLinkElements button;

    public ElementWithXYAttrSourceAndLinkElements getButton() {
        return button;
    }

    public void setButton(ElementWithXYAttrSourceAndLinkElements button) {
        this.button = button;
    }
}
