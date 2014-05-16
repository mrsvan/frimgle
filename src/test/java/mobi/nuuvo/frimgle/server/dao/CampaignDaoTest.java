package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertNotNull;
import mobi.nuuvo.frimgle.shared.domain.Campaign;
import mobi.nuuvo.frimgle.shared.domain.Project;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CampaignDaoTest extends AbstractDaoTest<Campaign, CampaignDao> {

	Injector injector;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		injector = Guice.createInjector(new DaoTestModule());
	}

	@Test
	public void testFindWithProjectEquals() {
		final Project project = new Project();
		injector.getInstance(ProjectDao.class).put(project);
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
