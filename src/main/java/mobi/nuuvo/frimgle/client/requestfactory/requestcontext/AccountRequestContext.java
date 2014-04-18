package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.AccountProxy;
import mobi.nuuvo.frimgle.server.dao.AccountDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = AccountDao.class, locator = InjectingServiceLocator.class)
public interface AccountRequestContext extends BaseRequestContext<AccountProxy> {

}
