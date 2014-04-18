package mobi.nuuvo.frimgle.client.requestfactory.proxy;

import mobi.nuuvo.frimgle.server.requestfactory.BaseLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

@ProxyFor(value = mobi.nuuvo.frimgle.shared.domain.Project.class, locator = BaseLocator.class)
public interface ProjectProxy extends EntityProxy {

  EntityProxyId<ProjectProxy> stableId();

  java.lang.Long getId();

  java.lang.Integer getVersion();

  java.lang.String getName();

  AccountProxy getAccount();

  void setName(java.lang.String name);

  void setAccount(AccountProxy account);

}
