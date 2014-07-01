package mobi.nuuvo.frimgle.server.player.campaign;

import mobi.nuuvo.frimgle.server.player.config.Config;
import mobi.nuuvo.frimgle.shared.domain.Campaign;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CampaignToEmailConfigMapperImplTest {

    public static final String LOGO_URL = "logoUrl";
    public static final String SKIP_BUTTON_IMG_URL = "skipButtonImgUrl";
    public static final String CTA_TITLE_IMG_URL = "ctaTitleImgUrl";
    public static final String CTA_BACKGROUND_IMG_URL = "ctaBackgrounImgUrl";
    public static final String CTA_BUTTON_IMG_URL = "ctaButtonImgUrl";
    public static final String FACEBOOK_THUMBNAIL_URL = "facebookThumbnailUrl";
    public static final String VIDEO_URL = "videoUrl";
    public static final String CTA_RECIPIENT_EMAIL = "ctaRecipientEmail";
    public static final String CTA_PLACEHOLDER_TEXT = "ctaPlaceholderText";
    public static final String THNX_TXT = "thnxTxt";
    public static final String FACEBOOK_TITLE = "facebookTitle";
    public static final String FACEBOOK_DESCRIPTION = "facebookDescription";
    private static Campaign campaign = new Campaign("My Test Campaign", LOGO_URL, SKIP_BUTTON_IMG_URL, CTA_TITLE_IMG_URL, CTA_BACKGROUND_IMG_URL, CTA_BUTTON_IMG_URL, FACEBOOK_THUMBNAIL_URL, VIDEO_URL, CTA_RECIPIENT_EMAIL, CTA_PLACEHOLDER_TEXT, THNX_TXT, FACEBOOK_TITLE, FACEBOOK_DESCRIPTION);
    private static CampaignToConfigMapper configMapper = new CampaignToEmailConfigMapperImpl();

    @Test
    public void testMap() throws Exception {
        Config config = configMapper.map(campaign);

        assertNotNull(config.getInteraction());
        assertNotNull(config.getHeaderimage());

        assertNotNull(config.getOg().getTitle());
        assertNotNull(config.getOg().getDescription());
        assertNotNull(config.getOg().getThumbnailfile());
        assertNotNull(config.getOg().getVideofile().getMp4());

        assertNotNull(config.getPlayer().getPoster());
        assertNotNull(config.getPlayer().getSkipbutton().getSource());

        assertNotNull(config.getCtaEmail().getButton().getSource());
        assertNotNull(config.getCtaEmail().getImage().getSource());
        assertNotNull(config.getCtaEmail().getEmailfield().getDefaultText());
        assertNotNull(config.getCtaEmail().getThanksfield().getDefaultText());

        assertEquals(Config.InteractionType.email, config.getInteraction());
        assertEquals(LOGO_URL, config.getHeaderimage());

        assertEquals(FACEBOOK_TITLE, config.getOg().getTitle());
        assertEquals(FACEBOOK_DESCRIPTION, config.getOg().getDescription());
        assertEquals(FACEBOOK_THUMBNAIL_URL, config.getOg().getThumbnailfile());
        assertEquals(VIDEO_URL, config.getOg().getVideofile().getMp4());

        assertEquals(CTA_BACKGROUND_IMG_URL, config.getPlayer().getPoster());
        assertEquals(SKIP_BUTTON_IMG_URL, config.getPlayer().getSkipbutton().getSource());

        assertEquals(CTA_BUTTON_IMG_URL, config.getCtaEmail().getButton().getSource());
        assertEquals(CTA_TITLE_IMG_URL, config.getCtaEmail().getImage().getSource());
        assertEquals(CTA_PLACEHOLDER_TEXT, config.getCtaEmail().getEmailfield().getDefaultText());
        assertEquals(THNX_TXT, config.getCtaEmail().getThanksfield().getDefaultText());
    }
}