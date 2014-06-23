package mobi.nuuvo.frimgle.server.player.config.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementWithXYAttrSourceAndLinkElements extends ElementWithXYAttrAndSource {

    @XmlElement
    private LinkElement link;

    public ElementWithXYAttrSourceAndLinkElements() {
        link = new LinkElement();
    }

    public ElementWithXYAttrSourceAndLinkElements(int x, int y, String source, LinkElement link) {
        super(x, y, source);
        this.link = link;
    }

    public LinkElement getLink() {
        return link;
    }

    public void setLink(LinkElement link) {
        this.link = link;
    }
}
