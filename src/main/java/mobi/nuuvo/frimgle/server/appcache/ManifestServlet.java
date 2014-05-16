package mobi.nuuvo.frimgle.server.appcache;

import org.realityforge.gwt.appcache.server.AbstractManifestServlet;
import org.realityforge.gwt.appcache.server.propertyprovider.UserAgentPropertyProvider;

import com.google.inject.Singleton;

@Singleton
public class ManifestServlet extends AbstractManifestServlet {

	private static final long serialVersionUID = 8400073252012937244L;

	public ManifestServlet() {
		addPropertyProvider(new UserAgentPropertyProvider());
	}

}
