package mobi.nuuvo.frimgle.client.requestfactory.proxy;

import mobi.nuuvo.frimgle.server.requestfactory.BaseLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = mobi.nuuvo.frimgle.shared.domain.User.class, locator = BaseLocator.class)
public interface UserProxy extends EntityProxy {

	EntityProxyId<UserProxy> stableId();

	java.lang.Long getId();

	java.lang.Integer getVersion();

	java.lang.String getName();

	java.lang.String getGoogleId();

	AccountProxy getAccount();

	void setName(java.lang.String name);

	void setGoogleId(java.lang.String googleId);

	void setAccount(AccountProxy account);

}
