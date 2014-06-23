package mobi.nuuvo.frimgle.server.player.config;

import mobi.nuuvo.frimgle.server.player.config.ctaconnect.CTAConnectConfig;
import mobi.nuuvo.frimgle.server.player.config.ctaemail.CTAEmailConfig;
import mobi.nuuvo.frimgle.server.player.config.ctalike.CTALikeConfig;
import mobi.nuuvo.frimgle.server.player.config.ctashare.CTAShareConfig;
import mobi.nuuvo.frimgle.server.player.config.ctastripe.CTAStripeConfig;
import mobi.nuuvo.frimgle.server.player.config.googleanalytics.GoogleAnalyticsConfig;
import mobi.nuuvo.frimgle.server.player.config.opengraph.OpenGraphConfig;
import mobi.nuuvo.frimgle.server.player.config.player.PlayerConfig;

import javax.xml.bind.annotation.*;

/**
 * Created by svd on 6/17/14.
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {

    @XmlAttribute
    private InteractionType interaction;
    @XmlAttribute
    private String headerimage;
    @XmlElement
    private OpenGraphConfig og;
    @XmlElement
    private GoogleAnalyticsConfig ga;
    @XmlElement
    private PlayerConfig player;
    @XmlElement(name = "CTAEmail")
    private CTAEmailConfig ctaEmail;
    @XmlElement(name = "CTAShare")
    private CTAShareConfig ctaShare;
    @XmlElement(name = "CTALike")
    private CTALikeConfig ctaLike;
    @XmlElement(name = "CTAConnect")
    private CTAConnectConfig ctaConnect;
    @XmlElement(name = "CTAStripe")
    private CTAStripeConfig ctaStripe;

    public Config() {
        interaction = InteractionType.email;
        og = new OpenGraphConfig();
        ga = new GoogleAnalyticsConfig();
        player = new PlayerConfig();
        ctaEmail = new CTAEmailConfig();
        ctaShare = new CTAShareConfig();
        ctaLike = new CTALikeConfig();
        ctaConnect = new CTAConnectConfig();
        ctaStripe = new CTAStripeConfig();
    }

    public Config(InteractionType interaction, String headerimage, OpenGraphConfig og, GoogleAnalyticsConfig ga, PlayerConfig player, CTAEmailConfig ctaEmail, CTAShareConfig ctaShare, CTALikeConfig ctaLike, CTAConnectConfig ctaConnect, CTAStripeConfig ctaStripe) {
        this.interaction = interaction;
        this.headerimage = headerimage;
        this.og = og;
        this.ga = ga;
        this.player = player;
        this.ctaEmail = ctaEmail;
        this.ctaShare = ctaShare;
        this.ctaLike = ctaLike;
        this.ctaConnect = ctaConnect;
        this.ctaStripe = ctaStripe;
    }

    public String getHeaderimage() {
        return headerimage;
    }

    public void setHeaderimage(String headerimage) {
        this.headerimage = headerimage;
    }

    public OpenGraphConfig getOg() {
        return og;
    }

    public void setOg(OpenGraphConfig og) {
        this.og = og;
    }

    public GoogleAnalyticsConfig getGa() {
        return ga;
    }

    public void setGa(GoogleAnalyticsConfig ga) {
        this.ga = ga;
    }

    public PlayerConfig getPlayer() {
        return player;
    }

    public void setPlayer(PlayerConfig player) {
        this.player = player;
    }

    public CTAEmailConfig getCtaEmail() {
        return ctaEmail;
    }

    public void setCtaEmail(CTAEmailConfig ctaEmail) {
        this.ctaEmail = ctaEmail;
    }

    public CTAShareConfig getCtaShare() {
        return ctaShare;
    }

    public void setCtaShare(CTAShareConfig ctaShare) {
        this.ctaShare = ctaShare;
    }

    public CTALikeConfig getCtaLike() {
        return ctaLike;
    }

    public void setCtaLike(CTALikeConfig ctaLike) {
        this.ctaLike = ctaLike;
    }

    public CTAConnectConfig getCtaConnect() {
        return ctaConnect;
    }

    public void setCtaConnect(CTAConnectConfig ctaConnect) {
        this.ctaConnect = ctaConnect;
    }

    public CTAStripeConfig getCtaStripe() {
        return ctaStripe;
    }

    public void setCtaStripe(CTAStripeConfig ctaStripe) {
        this.ctaStripe = ctaStripe;
    }

    public InteractionType getInteraction() {
        return interaction;
    }

    public void setInteraction(InteractionType interaction) {
        this.interaction = interaction;
    }

    @XmlEnum
    public enum InteractionType {
        email, share, like, connect, stripe;
    }
}
