package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertNotNull;
import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.Project;

import org.junit.Test;

public class ProjectDaoTest extends AbstractDaoTest<Project, ProjectDao> {

	@Test
	public void testFindWithAccountEquals() {
		final Account account = new Account();
		new AccountDao().put(account);
		testEntity.setAccount(account);
		testDao.put(testEntity);
		assertNotNull(testDao.findWithAccountEquals(account));
	}

	@Override
	protected Project newEntity() {
		return new Project();
	}

	@Override
	protected ProjectDao newDao() {
		return new ProjectDao();
	}

}
