package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.server.dao.ProjectDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = ProjectDao.class, locator = InjectingServiceLocator.class)
public interface ProjectRequestContext extends BaseRequestContext<ProjectProxy> {

}
