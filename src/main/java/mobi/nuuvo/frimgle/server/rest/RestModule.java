package mobi.nuuvo.frimgle.server.rest;

import com.google.inject.AbstractModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import mobi.nuuvo.frimgle.server.player.campaign.CampaignToConfigMapper;
import mobi.nuuvo.frimgle.server.player.campaign.CampaignToEmailConfigMapperImpl;

/**
 * Created by svd on 30.06.14.
 */
public class RestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GuiceContainer.class);
        bind(CampaignToConfigMapper.class).to(CampaignToEmailConfigMapperImpl.class).asEagerSingleton();

        PackagesResourceConfig resourceConfig = new PackagesResourceConfig(ConfigEndPoint.class.getPackage().getName());
        for (Class<?> resource : resourceConfig.getClasses()) {
            bind(resource);
        }
    }
}
