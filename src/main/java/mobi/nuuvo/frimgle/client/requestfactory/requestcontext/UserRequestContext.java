package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.UserProxy;
import mobi.nuuvo.frimgle.server.dao.UserDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = UserDao.class, locator = InjectingServiceLocator.class)
public interface UserRequestContext extends BaseRequestContext<UserProxy> {

}
