package mobi.nuuvo.frimgle.client.requestfactory.proxy;

import mobi.nuuvo.frimgle.server.requestfactory.BaseLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

@ProxyFor(value = mobi.nuuvo.frimgle.shared.domain.Account.class, locator = BaseLocator.class)
public interface AccountProxy extends EntityProxy {

	EntityProxyId<AccountProxy> stableId();

	java.lang.Long getId();

	java.lang.Integer getVersion();

	java.lang.String getName();

	void setName(java.lang.String name);

}
