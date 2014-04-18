package mobi.nuuvo.frimgle.server.guice;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * This is a Guice-injected service layer decorator. This class is part of the
 * glue you need to enable dependency injection on your ServiceLocators and
 * Locators.
 *
 * @author Etienne Pelletier
 *
 */
public class InjectedServiceLayerDecorator extends ServiceLayerDecorator {

	/**
	 * JSR 303 validator used to validate requested entities.
	 */
	private final Validator validator;

	/** The injector. */
	private final Injector injector;

	/**
	 * Instantiates a new injected service layer decorator.
	 *
	 * @param injector
	 *            the injector
	 * @param validator
	 *            the validator
	 */
	@Inject
	protected InjectedServiceLayerDecorator(final Injector injector,
			final Validator validator) {
		super();
		this.injector = injector;
		this.validator = validator;
	}

	/**
	 * Creates the locator.
	 *
	 * @param <T>
	 *            the generic type
	 * @param clazz
	 *            the clazz
	 * @return the t
	 */
	@Override
	public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
		return injector.getInstance(clazz);
	}

	/**
	 * Creates the service instance.
	 *
	 * @param requestContext
	 *            the request context
	 * @return the object
	 */
	@Override
	public Object createServiceInstance(
			Class<? extends RequestContext> requestContext) {
		Class<? extends ServiceLocator> serviceLocatorClass;
		if ((serviceLocatorClass = getTop().resolveServiceLocator(
				requestContext)) != null) {
			return injector.getInstance(serviceLocatorClass).getInstance(
					requestContext.getAnnotation(Service.class).value());
		} else {
			return null;
		}
	}

	/**
	 * Invokes JSR 303 validator on a given domain object.
	 *
	 * @param <T>
	 *            the type of the entity being validated
	 * @param domainObject
	 *            the domain object to be validated
	 * @return the violations associated with the domain object
	 */
	@Override
	public <T> Set<ConstraintViolation<T>> validate(T domainObject) {
		return validator.validate(domainObject);
	}
}