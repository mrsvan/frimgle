package mobi.nuuvo.frimgle.server.player.config.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementWithXY {
    @XmlAttribute
    private int x;
    @XmlAttribute
    private int y;

    /**
     * Convenience default constructor provided with invalid default settings.<br/>
     * Consider using {@link mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXY#ElementWithXY(int, int)} to instantiate an object with valid settings.
     */
    public ElementWithXY() {
        x = 0;
        y = 0;
    }

    /**
     * Instantiates an element with fully set fields.
     *
     * @param x coordinates in px
     * @param y coordinates in px
     */
    public ElementWithXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
