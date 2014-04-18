package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.server.dao.CampaignDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = CampaignDao.class, locator = InjectingServiceLocator.class)
public interface CampaignRequestContext extends BaseRequestContext<CampaignProxy> {

}
