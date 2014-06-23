package mobi.nuuvo.frimgle.server.player.config.ctaemail;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithDefaultText;
import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource;
import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrSourceAndLinkElements;
import mobi.nuuvo.frimgle.server.player.config.elements.LinkElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {@code
 * <CTAEmail>
 * <image x="80" y="50">
 * <!-- TOP IMAGE -->
 * <source>img/email-top.png</source>
 * <link target="_blank">#</link>
 * <!-- LINK WHEN CLICKING ON THE IMAGE -->
 * </image>
 * <emailfield x="40" y="80" width="220" height="33" font="Helvetica" size="14" color="#929191" border="true" borderColor="#ffffff" backgroundFill="true" backgroundColor="#ffffff" maxChars="50" text-align="center">
 * <defaultText>
 * <![CDATA[ adresse email ]]>
 * </defaultText>
 * <!-- EMAIL FIELD TITLE -->
 * </emailfield>
 * <button x="275" y="80">
 * <!-- BUTTON SEND IMAGE -->
 * <source>img/email-btn-send.png</source>
 * </button>
 * <thanksfield x="169" y="40" height="45" font="Helvetica" size="20" color="#FFFFFF" border="false" borderColor="#ffffff" backgroundFill="false" backgroundColor="#ffffff">
 * <defaultText>
 * <![CDATA[ Merci! ]]>
 * </defaultText>
 * <!-- THANK YOU TEXT -->
 * </thanksfield>
 * </CTAEmail>
 * }
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "CTAEmail")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTAEmailConfig {

    public static final String DEFAULT_FONT = "Helvetica";
    public static final String WHITE = "#FFFFFF";

    @XmlElement(name = "image")
    private ElementWithXYAttrSourceAndLinkElements image;
    @XmlElement(name = "emailfield")
    private ElementWithDefaultText emailfield;
    @XmlElement(name = "button")
    private ElementWithXYAttrAndSource button;
    @XmlElement(name = "thanksfield")
    private ElementWithDefaultText thanksfield;

    public CTAEmailConfig() {
        image = new ElementWithXYAttrSourceAndLinkElements(80, 50, null, new LinkElement("_blank", null));
        emailfield = new ElementWithDefaultText(40, 80, 220, 33, DEFAULT_FONT, 14, "#929191", true, WHITE, true, WHITE, 50, "center", null);
        button = new ElementWithXYAttrAndSource(275, 80, null);
        thanksfield = new ElementWithDefaultText(169, 40, 0, 45, DEFAULT_FONT, 20, WHITE, false, WHITE, false, WHITE, 50, "center", null);
    }

    public ElementWithXYAttrSourceAndLinkElements getImage() {
        return image;
    }

    public void setImage(ElementWithXYAttrSourceAndLinkElements image) {
        this.image = image;
    }

    public ElementWithDefaultText getEmailfield() {
        return emailfield;
    }

    public void setEmailfield(ElementWithDefaultText emailfield) {
        this.emailfield = emailfield;
    }

    public ElementWithXYAttrAndSource getButton() {
        return button;
    }

    public void setButton(ElementWithXYAttrAndSource button) {
        this.button = button;
    }

    public ElementWithDefaultText getThanksfield() {
        return thanksfield;
    }

    public void setThanksfield(ElementWithDefaultText thanksfield) {
        this.thanksfield = thanksfield;
    }
}
