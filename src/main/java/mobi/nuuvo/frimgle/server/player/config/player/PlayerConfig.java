package mobi.nuuvo.frimgle.server.player.config.player;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {@code
 * <!-- PLAYER CONFIGS -->
 * <player>
 * <poster>img/gnl-poster.jpg</poster>
 * <!-- POSTER IMAGE -->
 * <playbutton>img/gnl-btn-play.png</playbutton>
 * <!-- BUTTON PLAY IMAGE -->
 * <skipbutton x="290" y="128">
 * <!-- BUTTON SKIP IMAGE -->
 * <source>img/gnl-btn-skip.png</source>
 * </skipbutton>
 * </player>
 * }
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "player")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PlayerConfig {
    @XmlElement
    private String poster;
    @XmlElement
    private String playbutton;
    @XmlElement
    private ElementWithXYAttrAndSource skipbutton;

    public PlayerConfig() {
        skipbutton = new ElementWithXYAttrAndSource(290, 128, null);
    }

    public PlayerConfig(String poster, String playbutton, ElementWithXYAttrAndSource skipbutton) {
        this.poster = poster;
        this.playbutton = playbutton;
        this.skipbutton = skipbutton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerConfig)) return false;

        PlayerConfig that = (PlayerConfig) o;

        if (playbutton != null ? !playbutton.equals(that.playbutton) : that.playbutton != null) return false;
        if (poster != null ? !poster.equals(that.poster) : that.poster != null) return false;
        if (skipbutton != null ? !skipbutton.equals(that.skipbutton) : that.skipbutton != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = poster != null ? poster.hashCode() : 0;
        result = 31 * result + (playbutton != null ? playbutton.hashCode() : 0);
        result = 31 * result + (skipbutton != null ? skipbutton.hashCode() : 0);
        return result;
    }

    public ElementWithXYAttrAndSource getSkipbutton() {
        return skipbutton;
    }

    public void setSkipbutton(ElementWithXYAttrAndSource skipbutton) {
        this.skipbutton = skipbutton;
    }

    public String getPlaybutton() {
        return playbutton;
    }

    public void setPlaybutton(String playbutton) {
        this.playbutton = playbutton;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
