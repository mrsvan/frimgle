package mobi.nuuvo.frimgle.server.requestfactory;

import java.util.logging.Level;
import java.util.logging.Logger;

import mobi.nuuvo.frimgle.server.dao.objectify.OfyService;
import mobi.nuuvo.frimgle.shared.domain.BaseEntity;

import com.google.common.base.Preconditions;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.googlecode.objectify.Key;

public class BaseLocator extends Locator<BaseEntity, String> {

	/** The LOGGER constant for BaseLocator. */
	private static final Logger LOGGER = Logger.getLogger(BaseLocator.class
			.getName());

	@Override
	public BaseEntity create(Class<? extends BaseEntity> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE,
						"Failed to instantiate the provided class", e);
			}
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE, "Failed to access the provided class",
						e);
			}
			throw new RuntimeException(e);
		}
	}

	@Override
	public BaseEntity find(Class<? extends BaseEntity> clazz, String id) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO, "Finding " + clazz.getName() + ", id: " + id);
		}
		Key<BaseEntity> key = Key.create(id);
		return OfyService.ofy().load().key(key).now();
	}

	@Override
	public Class<BaseEntity> getDomainType() {
		throw new UnsupportedOperationException(
				"This method is normally never called by the RequestFactory API");
	};

	@Override
	public String getId(BaseEntity domainObject) {
		Preconditions.checkNotNull(domainObject);
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO,
					"Getting ID of " + domainObject.getClass().getName() + ": "
							+ domainObject.getId());
		}
		if (domainObject.getId() != null) {
			Key<BaseEntity> key = Key.create(domainObject);
			return key.getString();
		} else
			return null;
	}

	@Override
	public Class<String> getIdType() {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO, "Returning requested ID type: String");
		}
		return String.class;
	}

	@Override
	public Object getVersion(BaseEntity domainObject) {
		Preconditions.checkNotNull(domainObject);
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO, "Returning "
					+ domainObject.getClass().getName() + " version: "
					+ domainObject.getVersion());
		}
		return domainObject.getVersion();
	}

}
