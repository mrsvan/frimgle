package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertNotNull;
import mobi.nuuvo.frimgle.shared.domain.Campaign;
import mobi.nuuvo.frimgle.shared.domain.Project;

import org.junit.Test;

public class CampaignDaoTest extends AbstractDaoTest<Campaign, CampaignDao> {

	@Test
	public void testFindWithProjectEquals() {
		final Project project = new Project();
		new ProjectDao().put(project);
		testEntity.setProject(project);
		testDao.put(testEntity);
		assertNotNull(testDao.findWithProjectEquals(project));
	}

	@Override
	protected Campaign newEntity() {
		return new Campaign();
	}

	@Override
	protected CampaignDao newDao() {
		return new CampaignDao();
	}

}
