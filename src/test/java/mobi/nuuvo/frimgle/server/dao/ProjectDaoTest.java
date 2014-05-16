package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.Project;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProjectDaoTest extends AbstractDaoTest<Project, ProjectDao> {

	Injector injector;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		injector = Guice.createInjector(new DaoTestModule());
		testDao = injector.getInstance(ProjectDao.class);
	}

	@Test
	public void testFindWithAccountEquals() {
		final Account account = new Account();
		new AccountDao().put(account);
		testEntity.setAccount(account);
		testDao.put(testEntity);
		assertNotNull(testDao.findWithAccountEquals(account));
	}

	@Test
	public void testGetAll() {
		assertTrue("The test datastore config should not contain any entries",
				testDao.getAll().isEmpty());
		testDao.put(testEntity);
		assertTrue(
				"We created a test entity, but since we are not logged, we should not be able to find it in the datastore...",
				testDao.getAll().size() == 0);
	}

	@Override
	protected Project newEntity() {
		return new Project();
	}

	@Override
	protected ProjectDao newDao() {
		return null;
	}

}
