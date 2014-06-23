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
public class ElementWithXYAndOther extends ElementWithXY {

    @XmlAttribute
    private int width;
    @XmlAttribute
    private int height;
    @XmlAttribute
    private String font;
    @XmlAttribute
    private int size;
    @XmlAttribute
    private String color;
    @XmlAttribute
    private boolean border;
    @XmlAttribute
    private String borderColor;
    @XmlAttribute
    private boolean backgroundFill;
    @XmlAttribute
    private String backgroundColor;
    @XmlAttribute
    private int maxChars;
    @XmlAttribute(name = "text-align")
    private String textAlign;

    public ElementWithXYAndOther() {
    }

    public ElementWithXYAndOther(int x, int y, int width, int height, String font, int size, String color, boolean border, String borderColor, boolean backgroundFill, String backgroundColor, int maxChars, String textAlign) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.font = font;
        this.size = size;
        this.color = color;
        this.border = border;
        this.borderColor = borderColor;
        this.backgroundFill = backgroundFill;
        this.backgroundColor = backgroundColor;
        this.maxChars = maxChars;
        this.textAlign = textAlign;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMaxChars() {
        return maxChars;
    }

    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public boolean isBackgroundFill() {
        return backgroundFill;
    }

    public void setBackgroundFill(boolean backgroundFill) {
        this.backgroundFill = backgroundFill;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
