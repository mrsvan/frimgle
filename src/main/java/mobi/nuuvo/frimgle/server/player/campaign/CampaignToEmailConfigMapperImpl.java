package mobi.nuuvo.frimgle.server.player.campaign;

import mobi.nuuvo.frimgle.server.player.config.Config;
import mobi.nuuvo.frimgle.shared.domain.Campaign;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by svd on 30.06.14.
 */
public class CampaignToEmailConfigMapperImpl implements CampaignToConfigMapper {
    @Override
    public Config map(Campaign campaign) {
        checkNotNull(campaign);
        Config config = new Config();
        // The current implementation defaults to an email interaction - later version will select an implementation based on the Campaign settings
        config.setInteraction(Config.InteractionType.email);
        config.setHeaderimage(campaign.getLogoUrl());

        config.getOg().setTitle(campaign.getFacebookTitle());
        config.getOg().setDescription(campaign.getFacebookDescription());
        config.getOg().setThumbnailfile(campaign.getFacebookThumbnailUrl());
        config.getOg().getVideofile().setMp4(campaign.getVideoUrl());

        config.getPlayer().setPoster(campaign.getCtaBackgroundImgUrl());
        config.getPlayer().getSkipbutton().setSource(campaign.getSkipButtonImgUrl());

        config.getCtaEmail().getButton().setSource(campaign.getCtaButtonImgUrl());
        config.getCtaEmail().getImage().setSource(campaign.getCtaTitleImgUrl());
        config.getCtaEmail().getEmailfield().setDefaultText(campaign.getCtaPlaceholderText());
        config.getCtaEmail().getThanksfield().setDefaultText(campaign.getThnxTxt());
        return config;
    }
}
