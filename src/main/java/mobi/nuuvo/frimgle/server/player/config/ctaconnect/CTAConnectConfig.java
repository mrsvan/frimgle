package mobi.nuuvo.frimgle.server.player.config.ctaconnect;

import mobi.nuuvo.frimgle.server.player.config.elements.ElementWithXYAttrAndSource;

import javax.xml.bind.annotation.*;

/**
 * Created by svd on 6/18/14. {@code <!-- //List of all permissions can be found here :
 * https://developers.facebook.com/docs/facebook-login/permissions#adding// -->
 * <p/>
 * <CTAConnect appID="653224924743100" showfaces="true" permissions="email, user_location, user_likes, user_interests,
 * user_birthday, user_about_me, user_hometown"> <button x="100" y="100"> <!-- BUTTON CONNECT -->
 * <source>img/fb-btn-connect.png</source> </button> </CTAConnect>
 * <p/>
 * }
 */
@XmlRootElement(name = "CTAConnect")
@XmlAccessorType(XmlAccessType.FIELD)
public class CTAConnectConfig {

    @XmlAttribute
    private String appID;
    @XmlAttribute
    private boolean showfaces;
    @XmlAttribute
    private String permissions;
    @XmlElement(name = "button")
    private ElementWithXYAttrAndSource button;

    public CTAConnectConfig() {
        appID = "653224924743100";
        showfaces = true;
        permissions = "email, user_location, user_likes, user_interests, user_birthday, user_about_me, user_hometown";
        button = new ElementWithXYAttrAndSource(100, 100, null);
    }

    public CTAConnectConfig(String appID, boolean showfaces, String permissions, ElementWithXYAttrAndSource button) {
        this.appID = appID;
        this.showfaces = showfaces;
        this.permissions = permissions;
        this.button = button;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public boolean isShowfaces() {
        return showfaces;
    }

    public void setShowfaces(boolean showfaces) {
        this.showfaces = showfaces;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public ElementWithXYAttrAndSource getButton() {
        return button;
    }

    public void setButton(ElementWithXYAttrAndSource button) {
        this.button = button;
    }
}
