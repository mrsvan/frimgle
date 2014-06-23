package mobi.nuuvo.frimgle.server.player.config.ctalike;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource;
import mobi.nuuvo.frimgle.server.player.config.elements.LinkElement;

import javax.xml.bind.annotation.*;

/**
 * {@code
 * <CTALike showfaces="true">
 * <button x="70" y="15">
 * <!-- BUTTON LIKE -->
 * <source>img/fb-btn-like.png</source>
 * </button>
 * <link>http://facebook.com/bmw</link>
 * </CTALike>
 * }
 * Created by svd on 6/18/14.
 */
@XmlRootElement(name = "CTALike")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTALikeConfig {
    @XmlAttribute
    private boolean showfaces;

    @XmlElement(name = "button")
    private ElementWithXYAttrAndSource button;
    @XmlElement(name = "link")
    private LinkElement link;

    public ElementWithXYAttrAndSource getButton() {
        return button;
    }

    public void setButton(ElementWithXYAttrAndSource button) {
        this.button = button;
    }

    public LinkElement getLink() {
        return link;
    }

    public void setLink(LinkElement link) {
        this.link = link;
    }

    public boolean getShowfaces() {
        return showfaces;
    }

    public void setShowfaces(boolean showfaces) {
        this.showfaces = showfaces;
    }
}
