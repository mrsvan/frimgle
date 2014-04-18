package mobi.nuuvo.frimgle.server.guice;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;

/**
 * This is a Guice-injected RequestFactoryServlet. Use this to replace the
 * standard non-dependency-injected RequestFactory servlet.
 *
 * @author Etienne Pelletier
 */
@Singleton
public class InjectedRequestFactoryServlet extends RequestFactoryServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4253565330598588252L;

	/**
	 * Instantiates a new injected request factory servlet.
	 *
	 * @param exceptionHandler
	 *            the exception handler
	 * @param serviceLayerDecorator
	 *            the service layer decorator
	 */
	@Inject
	protected InjectedRequestFactoryServlet(
			final ExceptionHandler exceptionHandler,
			final ServiceLayerDecorator serviceLayerDecorator) {
		super(exceptionHandler, serviceLayerDecorator);
	}

}
