package mobi.nuuvo.frimgle.server.player.config;

import com.google.common.io.Resources;
import mobi.nuuvo.frimgle.server.player.config.ctaemail.CTAEmailConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConfigTest {

    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(Config.class);
        marshaller = context.createMarshaller();
        unmarshaller = context.createUnmarshaller();
    }

    /**
     * Test if the sample XML file can be unmarshalled and it creates the expected object.
     *
     * @throws Exception
     */
    @Test
    public void testUnmarshalXML() throws Exception {
        Config testConfig = (Config) unmarshaller.unmarshal(Resources.getResource(ConfigTest.class, "config.xml").openStream());

        Assert.assertEquals(Config.InteractionType.email, testConfig.getInteraction());
        Assert.assertEquals("img/audi_logo_new.gif", testConfig.getHeaderimage());

        Assert.assertEquals("Suivez votre instinct", testConfig.getOg().getTitle());
        Assert.assertEquals("Offre AutoCredit : l’Audi A3 Attraction 1.6 TDI 105 CV à paritr de € 199/mois TVAC. AutoCredit = prêt à tempérament avec des mensualités fixes initiales et une dernière mensualité plus élevée. Taux débiteut fixe de 2,99% sur tous les véhicules de la gamme A1, A3 et A4. Offre réservée aux particuliers du 01/09/2012 au 30/09/2012 sur maximum 48 mois et avec minimum 15% d’acompte. Kilométrage maximal par an: 30.000 km. Prêt à tempérament sous réserve d’acceptation du dossier pas Volkswagen D’Ieteren Finance S.A.  Infos sur www.audi.be", testConfig.getOg().getDescription());
        Assert.assertEquals("img/gnl-thumbnail.jpg", testConfig.getOg().getThumbnailfile());
        Assert.assertEquals("video/video.mp4", testConfig.getOg().getVideofile().getMp4());
        Assert.assertEquals("video/video.webm", testConfig.getOg().getVideofile().getWebm());

        Assert.assertEquals("UA-50046396-1", testConfig.getGa().getTrackingid());

        Assert.assertEquals("img/gnl-poster.jpg", testConfig.getPlayer().getPoster());
        Assert.assertEquals("img/gnl-btn-play.png", testConfig.getPlayer().getPlaybutton());
        Assert.assertEquals(290, testConfig.getPlayer().getSkipbutton().getX());
        Assert.assertEquals(128, testConfig.getPlayer().getSkipbutton().getY());
        Assert.assertEquals("img/gnl-btn-skip.png", testConfig.getPlayer().getSkipbutton().getSource());

        Assert.assertEquals(80, testConfig.getCtaEmail().getImage().getX());
        Assert.assertEquals(50, testConfig.getCtaEmail().getImage().getY());
        Assert.assertEquals("img/email-top.png", testConfig.getCtaEmail().getImage().getSource());
        Assert.assertEquals("_blank", testConfig.getCtaEmail().getImage().getLink().getTarget());
        Assert.assertEquals("#", testConfig.getCtaEmail().getImage().getLink().getValue());
        Assert.assertEquals(40, testConfig.getCtaEmail().getEmailfield().getX());
        Assert.assertEquals(80, testConfig.getCtaEmail().getEmailfield().getY());
        Assert.assertEquals(220, testConfig.getCtaEmail().getEmailfield().getWidth());
        Assert.assertEquals(33, testConfig.getCtaEmail().getEmailfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaEmail().getEmailfield().getFont());
        Assert.assertEquals(14, testConfig.getCtaEmail().getEmailfield().getSize());
        Assert.assertEquals("#929191", testConfig.getCtaEmail().getEmailfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaEmail().getEmailfield().isBorder());
        Assert.assertEquals("#ffffff", testConfig.getCtaEmail().getEmailfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaEmail().getEmailfield().isBackgroundFill());
        Assert.assertEquals("#ffffff", testConfig.getCtaEmail().getEmailfield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaEmail().getEmailfield().getMaxChars());
        Assert.assertEquals("center", testConfig.getCtaEmail().getEmailfield().getTextAlign());
        Assert.assertEquals(" adresse email", testConfig.getCtaEmail().getEmailfield().getDefaultText());
        Assert.assertEquals(275, testConfig.getCtaEmail().getButton().getX());
        Assert.assertEquals(80, testConfig.getCtaEmail().getButton().getY());
        Assert.assertEquals("img/email-btn-send.png", testConfig.getCtaEmail().getButton().getSource());
        Assert.assertEquals(169, testConfig.getCtaEmail().getThanksfield().getX());
        Assert.assertEquals(40, testConfig.getCtaEmail().getThanksfield().getY());
        Assert.assertEquals(45, testConfig.getCtaEmail().getThanksfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaEmail().getThanksfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaEmail().getThanksfield().getSize());
        Assert.assertEquals("#FFFFFF", testConfig.getCtaEmail().getThanksfield().getColor());
        Assert.assertEquals(false, testConfig.getCtaEmail().getThanksfield().isBorder());
        Assert.assertEquals("#ffffff", testConfig.getCtaEmail().getThanksfield().getBorderColor());
        Assert.assertEquals(false, testConfig.getCtaEmail().getThanksfield().isBackgroundFill());
        Assert.assertEquals("#ffffff", testConfig.getCtaEmail().getThanksfield().getBackgroundColor());
        Assert.assertEquals("Merci!", testConfig.getCtaEmail().getThanksfield().getDefaultText());

        Assert.assertEquals(145, testConfig.getCtaShare().getButton().getX());
        Assert.assertEquals(128, testConfig.getCtaShare().getButton().getY());
        Assert.assertEquals("img/fb-btn-share.png", testConfig.getCtaShare().getButton().getSource());

        Assert.assertEquals(true, testConfig.getCtaLike().getShowfaces());
        Assert.assertEquals(70, testConfig.getCtaLike().getButton().getX());
        Assert.assertEquals(15, testConfig.getCtaLike().getButton().getY());
        Assert.assertEquals("img/fb-btn-like.png", testConfig.getCtaLike().getButton().getSource());
        Assert.assertEquals("http://facebook.com/bmw", testConfig.getCtaLike().getLink().getValue());

        Assert.assertEquals("653224924743100", testConfig.getCtaConnect().getAppID());
        Assert.assertEquals(true, testConfig.getCtaConnect().isShowfaces());
        Assert.assertEquals("email, user_location, user_likes, user_interests, user_birthday, user_about_me, user_hometown", testConfig.getCtaConnect().getPermissions());
        Assert.assertEquals(100, testConfig.getCtaConnect().getButton().getX());
        Assert.assertEquals(100, testConfig.getCtaConnect().getButton().getY());
        Assert.assertEquals("img/fb-btn-connect.png", testConfig.getCtaConnect().getButton().getSource());

        Assert.assertEquals(300, testConfig.getCtaStripe().getAmount());
        Assert.assertEquals("usd", testConfig.getCtaStripe().getCurrency());
        Assert.assertEquals(18, testConfig.getCtaStripe().getNamefield().getX());
        Assert.assertEquals(18, testConfig.getCtaStripe().getNamefield().getY());
        Assert.assertEquals(360, testConfig.getCtaStripe().getNamefield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getNamefield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getNamefield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getNamefield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getNamefield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getNamefield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getNamefield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getNamefield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getNamefield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaStripe().getNamefield().getMaxChars());
        Assert.assertEquals("Your Name :", testConfig.getCtaStripe().getNamefield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getEmailfield().getX());
        Assert.assertEquals(68, testConfig.getCtaStripe().getEmailfield().getY());
        Assert.assertEquals(360, testConfig.getCtaStripe().getEmailfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getEmailfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getEmailfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getEmailfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getEmailfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getEmailfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getEmailfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getEmailfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getEmailfield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaStripe().getEmailfield().getMaxChars());
        Assert.assertEquals("E-mail Address :", testConfig.getCtaStripe().getEmailfield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getCardnumberfield().getX());
        Assert.assertEquals(118, testConfig.getCtaStripe().getCardnumberfield().getY());
        Assert.assertEquals(250, testConfig.getCtaStripe().getCardnumberfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getCardnumberfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getCardnumberfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCardnumberfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getCardnumberfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCardnumberfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getCardnumberfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCardnumberfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getCardnumberfield().getBackgroundColor());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCardnumberfield().getMaxChars());
        Assert.assertEquals("Card Number :", testConfig.getCtaStripe().getCardnumberfield().getDefaultText());
        Assert.assertEquals(278, testConfig.getCtaStripe().getCvcfield().getX());
        Assert.assertEquals(118, testConfig.getCtaStripe().getCvcfield().getY());
        Assert.assertEquals(100, testConfig.getCtaStripe().getCvcfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getCvcfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getCvcfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCvcfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getCvcfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCvcfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getCvcfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCvcfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getCvcfield().getBackgroundColor());
        Assert.assertEquals(3, testConfig.getCtaStripe().getCvcfield().getMaxChars());
        Assert.assertEquals("CVC :", testConfig.getCtaStripe().getCvcfield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getExpirationmonthfield().getX());
        Assert.assertEquals(168, testConfig.getCtaStripe().getExpirationmonthfield().getY());
        Assert.assertEquals(160, testConfig.getCtaStripe().getExpirationmonthfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getExpirationmonthfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getExpirationmonthfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getExpirationmonthfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getExpirationmonthfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationmonthfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getExpirationmonthfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationmonthfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getExpirationmonthfield().getBackgroundColor());
        Assert.assertEquals(2, testConfig.getCtaStripe().getExpirationmonthfield().getMaxChars());
        Assert.assertEquals("Expiry Month:", testConfig.getCtaStripe().getExpirationmonthfield().getDefaultText());
        Assert.assertEquals(218, testConfig.getCtaStripe().getExpirationyearfield().getX());
        Assert.assertEquals(168, testConfig.getCtaStripe().getExpirationyearfield().getY());
        Assert.assertEquals(160, testConfig.getCtaStripe().getExpirationyearfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getExpirationyearfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getExpirationyearfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getExpirationyearfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getExpirationyearfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationyearfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getExpirationyearfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationyearfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getExpirationyearfield().getBackgroundColor());
        Assert.assertEquals(4, testConfig.getCtaStripe().getExpirationyearfield().getMaxChars());
        Assert.assertEquals("Expiry Year:", testConfig.getCtaStripe().getExpirationyearfield().getDefaultText());
        Assert.assertEquals(100, testConfig.getCtaStripe().getButton().getX());
        Assert.assertEquals(208, testConfig.getCtaStripe().getButton().getY());
        Assert.assertEquals("img/stripe-btn-submit.png", testConfig.getCtaStripe().getButton().getSource());
    }

    /**
     * Test if the sample XML file can be unmarshalled and it creates the expected object.
     *
     * @throws Exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        Config testConfig = new Config();

        Assert.assertEquals(Config.InteractionType.email, testConfig.getInteraction());
        Assert.assertEquals(null, testConfig.getHeaderimage());

        Assert.assertEquals(null, testConfig.getOg().getTitle());
        Assert.assertEquals(null, testConfig.getOg().getDescription());
        Assert.assertEquals(null, testConfig.getOg().getThumbnailfile());
        Assert.assertEquals(null, testConfig.getOg().getVideofile().getMp4());
        Assert.assertEquals(null, testConfig.getOg().getVideofile().getWebm());

        Assert.assertEquals("UA-50046396-1", testConfig.getGa().getTrackingid());

        Assert.assertEquals(null, testConfig.getPlayer().getPoster());
        Assert.assertEquals(null, testConfig.getPlayer().getPlaybutton());
        Assert.assertEquals(290, testConfig.getPlayer().getSkipbutton().getX());
        Assert.assertEquals(128, testConfig.getPlayer().getSkipbutton().getY());
        Assert.assertEquals(null, testConfig.getPlayer().getSkipbutton().getSource());

        Assert.assertEquals(80, testConfig.getCtaEmail().getImage().getX());
        Assert.assertEquals(50, testConfig.getCtaEmail().getImage().getY());
        Assert.assertEquals(null, testConfig.getCtaEmail().getImage().getSource());
        Assert.assertEquals("_blank", testConfig.getCtaEmail().getImage().getLink().getTarget());
        Assert.assertEquals(null, testConfig.getCtaEmail().getImage().getLink().getValue());
        Assert.assertEquals(40, testConfig.getCtaEmail().getEmailfield().getX());
        Assert.assertEquals(80, testConfig.getCtaEmail().getEmailfield().getY());
        Assert.assertEquals(220, testConfig.getCtaEmail().getEmailfield().getWidth());
        Assert.assertEquals(33, testConfig.getCtaEmail().getEmailfield().getHeight());
        Assert.assertEquals(CTAEmailConfig.DEFAULT_FONT, testConfig.getCtaEmail().getEmailfield().getFont());
        Assert.assertEquals(14, testConfig.getCtaEmail().getEmailfield().getSize());
        Assert.assertEquals("#929191", testConfig.getCtaEmail().getEmailfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaEmail().getEmailfield().isBorder());
        Assert.assertEquals(CTAEmailConfig.WHITE, testConfig.getCtaEmail().getEmailfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaEmail().getEmailfield().isBackgroundFill());
        Assert.assertEquals(CTAEmailConfig.WHITE, testConfig.getCtaEmail().getEmailfield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaEmail().getEmailfield().getMaxChars());
        Assert.assertEquals("center", testConfig.getCtaEmail().getEmailfield().getTextAlign());
        Assert.assertEquals(null, testConfig.getCtaEmail().getEmailfield().getDefaultText());
        Assert.assertEquals(275, testConfig.getCtaEmail().getButton().getX());
        Assert.assertEquals(80, testConfig.getCtaEmail().getButton().getY());
        Assert.assertEquals(null, testConfig.getCtaEmail().getButton().getSource());
        Assert.assertEquals(169, testConfig.getCtaEmail().getThanksfield().getX());
        Assert.assertEquals(40, testConfig.getCtaEmail().getThanksfield().getY());
        Assert.assertEquals(45, testConfig.getCtaEmail().getThanksfield().getHeight());
        Assert.assertEquals(CTAEmailConfig.DEFAULT_FONT, testConfig.getCtaEmail().getThanksfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaEmail().getThanksfield().getSize());
        Assert.assertEquals(CTAEmailConfig.WHITE, testConfig.getCtaEmail().getThanksfield().getColor());
        Assert.assertEquals(false, testConfig.getCtaEmail().getThanksfield().isBorder());
        Assert.assertEquals(CTAEmailConfig.WHITE, testConfig.getCtaEmail().getThanksfield().getBorderColor());
        Assert.assertEquals(false, testConfig.getCtaEmail().getThanksfield().isBackgroundFill());
        Assert.assertEquals(CTAEmailConfig.WHITE, testConfig.getCtaEmail().getThanksfield().getBackgroundColor());
        Assert.assertEquals(null, testConfig.getCtaEmail().getThanksfield().getDefaultText());

        Assert.assertEquals(145, testConfig.getCtaShare().getButton().getX());
        Assert.assertEquals(128, testConfig.getCtaShare().getButton().getY());
        Assert.assertEquals(null, testConfig.getCtaShare().getButton().getSource());

        Assert.assertEquals(true, testConfig.getCtaLike().getShowfaces());
        Assert.assertEquals(70, testConfig.getCtaLike().getButton().getX());
        Assert.assertEquals(15, testConfig.getCtaLike().getButton().getY());
        Assert.assertEquals(null, testConfig.getCtaLike().getButton().getSource());
        Assert.assertEquals(null, testConfig.getCtaLike().getLink().getValue());

        Assert.assertEquals("653224924743100", testConfig.getCtaConnect().getAppID());
        Assert.assertEquals(true, testConfig.getCtaConnect().isShowfaces());
        Assert.assertEquals("email, user_location, user_likes, user_interests, user_birthday, user_about_me, user_hometown", testConfig.getCtaConnect().getPermissions());
        Assert.assertEquals(100, testConfig.getCtaConnect().getButton().getX());
        Assert.assertEquals(100, testConfig.getCtaConnect().getButton().getY());
        Assert.assertEquals("img/fb-btn-connect.png", testConfig.getCtaConnect().getButton().getSource());

        Assert.assertEquals(300, testConfig.getCtaStripe().getAmount());
        Assert.assertEquals("usd", testConfig.getCtaStripe().getCurrency());
        Assert.assertEquals(18, testConfig.getCtaStripe().getNamefield().getX());
        Assert.assertEquals(18, testConfig.getCtaStripe().getNamefield().getY());
        Assert.assertEquals(360, testConfig.getCtaStripe().getNamefield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getNamefield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getNamefield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getNamefield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getNamefield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getNamefield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getNamefield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getNamefield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getNamefield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaStripe().getNamefield().getMaxChars());
        Assert.assertEquals("Your Name :", testConfig.getCtaStripe().getNamefield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getEmailfield().getX());
        Assert.assertEquals(68, testConfig.getCtaStripe().getEmailfield().getY());
        Assert.assertEquals(360, testConfig.getCtaStripe().getEmailfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getEmailfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getEmailfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getEmailfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getEmailfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getEmailfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getEmailfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getEmailfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getEmailfield().getBackgroundColor());
        Assert.assertEquals(50, testConfig.getCtaStripe().getEmailfield().getMaxChars());
        Assert.assertEquals("E-mail Address :", testConfig.getCtaStripe().getEmailfield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getCardnumberfield().getX());
        Assert.assertEquals(118, testConfig.getCtaStripe().getCardnumberfield().getY());
        Assert.assertEquals(250, testConfig.getCtaStripe().getCardnumberfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getCardnumberfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getCardnumberfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCardnumberfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getCardnumberfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCardnumberfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getCardnumberfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCardnumberfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getCardnumberfield().getBackgroundColor());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCardnumberfield().getMaxChars());
        Assert.assertEquals("Card Number :", testConfig.getCtaStripe().getCardnumberfield().getDefaultText());
        Assert.assertEquals(278, testConfig.getCtaStripe().getCvcfield().getX());
        Assert.assertEquals(118, testConfig.getCtaStripe().getCvcfield().getY());
        Assert.assertEquals(100, testConfig.getCtaStripe().getCvcfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getCvcfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getCvcfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getCvcfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getCvcfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCvcfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getCvcfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getCvcfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getCvcfield().getBackgroundColor());
        Assert.assertEquals(3, testConfig.getCtaStripe().getCvcfield().getMaxChars());
        Assert.assertEquals("CVC :", testConfig.getCtaStripe().getCvcfield().getDefaultText());
        Assert.assertEquals(18, testConfig.getCtaStripe().getExpirationmonthfield().getX());
        Assert.assertEquals(168, testConfig.getCtaStripe().getExpirationmonthfield().getY());
        Assert.assertEquals(160, testConfig.getCtaStripe().getExpirationmonthfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getExpirationmonthfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getExpirationmonthfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getExpirationmonthfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getExpirationmonthfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationmonthfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getExpirationmonthfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationmonthfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getExpirationmonthfield().getBackgroundColor());
        Assert.assertEquals(2, testConfig.getCtaStripe().getExpirationmonthfield().getMaxChars());
        Assert.assertEquals("Expiry Month:", testConfig.getCtaStripe().getExpirationmonthfield().getDefaultText());
        Assert.assertEquals(218, testConfig.getCtaStripe().getExpirationyearfield().getX());
        Assert.assertEquals(168, testConfig.getCtaStripe().getExpirationyearfield().getY());
        Assert.assertEquals(160, testConfig.getCtaStripe().getExpirationyearfield().getWidth());
        Assert.assertEquals(30, testConfig.getCtaStripe().getExpirationyearfield().getHeight());
        Assert.assertEquals("Helvetica", testConfig.getCtaStripe().getExpirationyearfield().getFont());
        Assert.assertEquals(20, testConfig.getCtaStripe().getExpirationyearfield().getSize());
        Assert.assertEquals("#6E6E6E", testConfig.getCtaStripe().getExpirationyearfield().getColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationyearfield().isBorder());
        Assert.assertEquals("#D8D8D8", testConfig.getCtaStripe().getExpirationyearfield().getBorderColor());
        Assert.assertEquals(true, testConfig.getCtaStripe().getExpirationyearfield().isBackgroundFill());
        Assert.assertEquals("#000000", testConfig.getCtaStripe().getExpirationyearfield().getBackgroundColor());
        Assert.assertEquals(4, testConfig.getCtaStripe().getExpirationyearfield().getMaxChars());
        Assert.assertEquals("Expiry Year:", testConfig.getCtaStripe().getExpirationyearfield().getDefaultText());
        Assert.assertEquals(100, testConfig.getCtaStripe().getButton().getX());
        Assert.assertEquals(208, testConfig.getCtaStripe().getButton().getY());
        Assert.assertEquals("img/stripe-btn-submit.png", testConfig.getCtaStripe().getButton().getSource());
    }

}