package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import java.util.List;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.server.dao.ProjectDao;
import mobi.nuuvo.frimgle.server.guice.InjectingServiceLocator;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = ProjectDao.class, locator = InjectingServiceLocator.class)
public interface ProjectRequestContext extends BaseRequestContext<ProjectProxy> {

	/**
	 * Store the provided entity in the datastore and ensure it's account is
	 * equal to the currently logged in user's account.
	 *
	 * @param entity
	 *            a project that should be saved
	 * @return the saved project with its updated fields
	 */
	public Request<ProjectProxy> putMy(ProjectProxy entity);

	/**
	 * Get all the projects from the datastore with an account equal to the
	 * logged in user's account field.
	 *
	 * @return a list of the logged in user's projects
	 */
	public Request<List<ProjectProxy>> getAllMy();

	public Request<Integer> findMyTotalCount();
}
