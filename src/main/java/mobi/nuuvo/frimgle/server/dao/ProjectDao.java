package mobi.nuuvo.frimgle.server.dao;

import java.util.List;

import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.Project;

/**
 * The Class ProjectDao.
 */
public class ProjectDao extends BaseDao<Project> {

	/**
	 * Instantiates a new project dao.
	 */
	public ProjectDao() {
		super(Project.class);
	}

	/**
	 * Find with account equals.
	 *
	 * @param account the account
	 * @return the list
	 */
	public List<Project> findWithAccountEquals(final Account account) {
		return query().ancestor(account).list();
	}
}
