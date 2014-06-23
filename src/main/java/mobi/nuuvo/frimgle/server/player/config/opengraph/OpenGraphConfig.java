package mobi.nuuvo.frimgle.server.player.config.opengraph;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {@code
 * <og>
 * <title>Suivez votre instinct</title>
 * <description>
 * Offre AutoCredit : l’Audi A3 Attraction 1.6 TDI 105 CV à paritr de € 199/mois TVAC. AutoCredit = prêt à tempérament avec des mensualités fixes initiales et une dernière mensualité plus élevée. Taux débiteut fixe de 2,99% sur tous les véhicules de la gamme A1, A3 et A4. Offre réservée aux particuliers du 01/09/2012 au 30/09/2012 sur maximum 48 mois et avec minimum 15% d’acompte. Kilométrage maximal par an: 30.000 km. Prêt à tempérament sous réserve d’acceptation du dossier pas Volkswagen D’Ieteren Finance S.A. Infos sur www.audi.be
 * </description>
 * <thumbnailfile>img/gnl-thumbnail.jpg</thumbnailfile>
 * <videofile>
 * <mp4>video/video.mp4</mp4>
 * <webm>video/video.webm</webm>
 * </videofile>
 * </og>
 * }
 * <p/>
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "og")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenGraphConfig {
    @XmlElement
    private String title;
    @XmlElement
    private String description;
    @XmlElement
    private String thumbnailfile;
    @XmlElement
    private VideofileConfig videofile;

    public OpenGraphConfig(String title, String description, String thumbnailfile, VideofileConfig videofile) {
        this.title = title;
        this.description = description;
        this.thumbnailfile = thumbnailfile;
        this.videofile = videofile;
    }

    public OpenGraphConfig() {
        videofile = new VideofileConfig();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailfile() {
        return thumbnailfile;
    }

    public void setThumbnailfile(String thumbnailfile) {
        this.thumbnailfile = thumbnailfile;
    }

    public VideofileConfig getVideofile() {
        return videofile;
    }

    public void setVideofile(VideofileConfig videofile) {
        this.videofile = videofile;
    }
}
