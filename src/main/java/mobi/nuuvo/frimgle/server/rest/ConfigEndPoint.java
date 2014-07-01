package mobi.nuuvo.frimgle.server.rest;

import com.googlecode.objectify.Key;
import mobi.nuuvo.frimgle.server.dao.CampaignDao;
import mobi.nuuvo.frimgle.server.player.campaign.CampaignToConfigMapper;
import mobi.nuuvo.frimgle.server.player.config.Config;
import mobi.nuuvo.frimgle.shared.domain.Campaign;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * A restful endpoint for serving Frimgle player config files Created by svd on 30.06.14.
 */
@Path("/config")
public class ConfigEndPoint {

    final CampaignDao campaignDao;
    final CampaignToConfigMapper configMapper;

    @Inject
    public ConfigEndPoint(final CampaignDao campaignDao, final CampaignToConfigMapper configMapper) {
        this.campaignDao = campaignDao;
        this.configMapper = configMapper;
    }

    @Path("/{id}")
    @GET
    @Produces({"application/xml", "application/json"})
    public Config getConfig(@PathParam("id") String id) {
        Config config;

        final Key<Campaign> campaignKey = Key.create(id);

        final Campaign campaign = campaignDao.get(campaignKey);

        config = campaign == null ? null : configMapper.map(campaign);

        return config;
    }

}
