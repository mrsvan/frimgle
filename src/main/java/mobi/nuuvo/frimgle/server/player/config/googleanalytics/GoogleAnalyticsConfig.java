package mobi.nuuvo.frimgle.server.player.config.googleanalytics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "ga")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoogleAnalyticsConfig {
    /**
     * The Google Analytics tracking id.
     * frimgle.com : UA-31561418-1, frimglebeta.com : UA-50046396-1
     */
    @XmlAttribute
    private String trackingid = "UA-50046396-1";

    public GoogleAnalyticsConfig(String trackingid) {
        this.trackingid = trackingid;
    }

    public GoogleAnalyticsConfig() {

    }

    public String getTrackingid() {
        return trackingid;
    }

    public void setTrackingid(String trackingid) {
        this.trackingid = trackingid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoogleAnalyticsConfig)) return false;

        GoogleAnalyticsConfig that = (GoogleAnalyticsConfig) o;

        if (trackingid != null ? !trackingid.equals(that.trackingid) : that.trackingid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return trackingid != null ? trackingid.hashCode() : 0;
    }
}
