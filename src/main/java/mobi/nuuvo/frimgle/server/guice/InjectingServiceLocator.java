package mobi.nuuvo.frimgle.server.guice;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * This is Guice-injected ServiceLocator.  Use this class to provide dependency-injected
 * instances of your RequestFactory services. When defining a new Request interface,
 * set this in the locator attribute of the @Service annotation.
 *
 * @author Etienne Pelletier
 *
 */
public class InjectingServiceLocator implements ServiceLocator {

  /** The injector. */
  private final Injector injector;

  /**
   * Instantiates a new injecting service locator.
   *
   * @param injector the injector
   */
  @Inject
  protected InjectingServiceLocator(final Injector injector) {
    super();
    this.injector = injector;
  }

  /* (non-Javadoc)
   * @see com.google.web.bindery.requestfactory.shared.ServiceLocator#getInstance(java.lang.Class)
   */
  @Override
  public Object getInstance(Class<?> clazz) {
    return injector.getInstance(clazz);
  }

}