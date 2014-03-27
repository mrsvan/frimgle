package mobi.nuuvo.frimgle.server.dao;

import java.util.List;

import mobi.nuuvo.frimgle.shared.domain.Campaign;
import mobi.nuuvo.frimgle.shared.domain.Project;

/**
 * The Class CampaignDao.
 */
public class CampaignDao extends BaseDao<Campaign> {

	/**
	 * Instantiates a new campaign dao.
	 */
	public CampaignDao() {
		super(Campaign.class);
	}

	/**
	 * Find with project equals.
	 *
	 * @param project the project
	 * @return the list
	 */
	public List<Campaign> findWithProjectEquals(final Project project) {
		return query().ancestor(project).list();
	}
}
