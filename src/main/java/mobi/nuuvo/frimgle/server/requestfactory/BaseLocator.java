package mobi.nuuvo.frimgle.server.requestfactory;

import mobi.nuuvo.frimgle.server.dao.objectify.OfyService;
import mobi.nuuvo.frimgle.shared.domain.BaseEntity;

import com.google.web.bindery.requestfactory.shared.Locator;

public class BaseLocator extends Locator<BaseEntity, Long> {

	@Override
	public BaseEntity create(Class<? extends BaseEntity> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public BaseEntity find(Class<? extends BaseEntity> clazz, Long id) {
		return OfyService.ofy().load().type(clazz).id(id).now();
	}

	@Override
	public Class<BaseEntity> getDomainType() {
		throw new UnsupportedOperationException(
				"This method is normally never called by the RequestFactory API");
	};

	@Override
	public Long getId(BaseEntity domainObject) {
		return domainObject == null ? null : domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(BaseEntity domainObject) {
		return domainObject.getVersion();
	}

}
