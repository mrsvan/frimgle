package mobi.nuuvo.frimgle.server.player.config.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementWithDefaultText extends ElementWithXYAndOther {
    @XmlElement
    @XmlJavaTypeAdapter(AdaptorCDATA.class)
    private String defaultText;

    public ElementWithDefaultText() {
    }

    public ElementWithDefaultText(int x, int y, int width, int height, String font, int size, String color, boolean border, String borderColor, boolean backgroundFill, String backgroundColor, int maxChars, String textAlign, String defaultText) {
        super(x, y, width, height, font, size, color, border, borderColor, backgroundFill, backgroundColor, maxChars, textAlign);
        this.defaultText = defaultText;
    }

    public ElementWithDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }
}
