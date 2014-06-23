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
public class ElementWithXYAttrAndSource extends ElementWithXY {
    @XmlElement
    private String source;

    /**
     * Provided for convenience, but the resulting object does not have any practical working defaults set.
     * <br/>
     * You may prefer instantiating an object with more feasible settings using {@link mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource#ElementWithXYAttrAndSource(int, int, String)}...
     */
    public ElementWithXYAttrAndSource() {
    }

    /**
     * Instantiate a full configured instance of this object, with all configurable fields set.
     *
     * @param x      coordinates in px
     * @param y      coordinates in px
     * @param source URL of the element
     */
    public ElementWithXYAttrAndSource(int x, int y, String source) {
        super(x, y);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
