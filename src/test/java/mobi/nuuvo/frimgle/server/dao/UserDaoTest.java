/**
 *
 */
package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.User;

import org.junit.Test;

/**
 * @author "Stefaan Vanderheyden (svd@nuuvo.mobi)"
 *
 */
public class UserDaoTest extends AbstractDaoTest<User, UserDao> {

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.UserDao#findByGoogleId(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByGoogleId() {
		final String googleId = "fakeGoogleId";
		testEntity.setGoogleId(googleId);
		testDao.put(testEntity);
		assertNotNull(
				"Did not find expected user with Google ID = " + googleId,
				testDao.findByGoogleId(googleId));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.UserDao#findWithAccountEquals(mobi.nuuvo.frimgle.shared.domain.Account)}
	 * .
	 */
	@Test
	public void testFindWithAccountEquals() {
		Account account = new Account();
		new AccountDao().put(account);
		testEntity.setAccount(account);
		testDao.put(testEntity);
		assertTrue("Failed to find a user by account", !testDao
				.findWithAccountEquals(account).isEmpty());
	}

	@Override
	protected User newEntity() {
		return new User();
	}

	@Override
	protected UserDao newDao() {
		return new UserDao();
	}

	@Override
	public void testPutT() {
		super.testPutT();
		assertNotNull(testEntity.getAccount());
	}

	@Override
	public void testPutIterableOfT() {
		super.testPutIterableOfT();
		for (User user : testDao.getAll()) {
			assertNotNull(user.getAccount());
		}
	}
}
