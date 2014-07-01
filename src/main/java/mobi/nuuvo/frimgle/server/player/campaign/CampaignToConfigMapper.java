package mobi.nuuvo.frimgle.server.player.campaign;

import mobi.nuuvo.frimgle.server.player.config.Config;
import mobi.nuuvo.frimgle.shared.domain.Campaign;

/**
 * Implement this calls to map any {@link mobi.nuuvo.frimgle.shared.domain.Campaign} instance to a new {@link
 * mobi.nuuvo.frimgle.server.player.config.Config} instance. Created by svd on 30.06.14.
 */
public interface CampaignToConfigMapper {
    /**
     * Map a valid Campaign to a new Config instance.
     *
     * @param campaign a valid {@link mobi.nuuvo.frimgle.shared.domain.Campaign}
     * @return a new {@link mobi.nuuvo.frimgle.server.player.config.Config}
     */
    Config map(Campaign campaign);
}
