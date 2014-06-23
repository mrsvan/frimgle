package mobi.nuuvo.frimgle.server.player.config.opengraph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "videofile")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class VideofileConfig {
    @XmlElement
    private String mp4;
    @XmlElement(required = false)
    private String webm;

    public String getWebm() {
        return webm;
    }

    public void setWebm(String webm) {
        this.webm = webm;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }
}
