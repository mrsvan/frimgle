package mobi.nuuvo.frimgle.server.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mobi.nuuvo.frimgle.server.authentication.CurrentUserDtoProvider;
import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.Project;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * The Class ProjectDao.
 */
public class ProjectDao extends BaseDao<Project> {

	/** The LOGGER constant for ProjectDao. */
	private static final Logger LOGGER = Logger.getLogger(ProjectDao.class
			.getName());

	private final CurrentUserDtoProvider currentUserDtoProvider;

	/**
	 * Instantiates a new project dao.
	 */
	@Inject
	public ProjectDao(final CurrentUserDtoProvider currentUserDtoProvider) {
		super(Project.class);
		Preconditions
				.checkState(
						currentUserDtoProvider != null,
						"currentUserDtoProvider was not correctly injected, make sure you check your Guice setup");
		this.currentUserDtoProvider = currentUserDtoProvider;
	}

	@Override
	public List<Project> getAll() {
		try {
			if (currentUserDtoProvider.get().isAdmin()) {
				return query().order("-dateCreated").list();
			}
		} catch (NullPointerException e) {
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE, "A process attempted to get all projects without a valid logged in user.", e);
			}
		}
		return Lists.newArrayList();
	}

	/**
	 * Get all the projects of the logged in user.
	 * @return a list of projects with an Account field equal to the logged in user's account
	 */
	public List<Project> getAllMy() {
		return findWithAccountEquals(currentUserDtoProvider.get().getUser()
				.getAccount());
	}

	/**
	 * Put the provided project in the datastore and force it's account field to be equal to the currently logged in user's account.
	 * @param object the project that will be stored in the datastore
	 * @return
	 */
	public Project putMy(Project object) {
		object.setAccount(currentUserDtoProvider.get().getUser().getAccount());
		return super.put(object);
	}

	/**
	 * Find with account equals.
	 *
	 * @param account
	 *            the account
	 * @return the list
	 */
	public List<Project> findWithAccountEquals(final Account account) {
		Preconditions
				.checkNotNull(account,
						"You must provide a non-null account as a filter for this method");
		return query().ancestor(account).order("-dateCreated").list();
	}

	public Integer findMyTotalCount() {
		return query().ancestor(currentUserDtoProvider.get().getUser().getAccount()).count();
	}
}
