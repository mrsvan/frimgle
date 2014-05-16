package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import java.util.List;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.server.dao.CampaignDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = CampaignDao.class, locator = InjectingServiceLocator.class)
public interface CampaignRequestContext extends
		BaseRequestContext<CampaignProxy> {

	public Request<List<CampaignProxy>> findWithProjectEquals(
			ProjectProxy project);

	public Request<Integer> countWithProjectEquals(ProjectProxy project);

	@Override
	public Request<CampaignProxy> put(CampaignProxy entity);
}
