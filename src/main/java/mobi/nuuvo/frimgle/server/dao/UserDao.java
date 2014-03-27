package mobi.nuuvo.frimgle.server.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.User;

import com.google.common.base.Optional;

/**
 * The Class UserDao.
 */
public class UserDao extends BaseDao<User> {

	/**
	 * Instantiates a new user dao.
	 */
	public UserDao() {
		super(User.class);
	}

	/**
	 * Find by google id.
	 *
	 * @param googleId
	 *            the google id
	 * @return the user
	 */
	public User findByGoogleId(String googleId) {
		return query().filter("googleId =", googleId).first().now();
	}

	/**
	 * Find with account equals.
	 *
	 * @param account
	 *            the account
	 * @return the list
	 */
	public List<User> findWithAccountEquals(final Account account) {
		return query().filter("account", account).list();
	}

	@Override
	public Collection<User> put(Iterable<User> entities) {
		for (User user : entities) {
			ensureHasAccount(user);
		}
		return super.put(entities);
	}

	@Override
	public User put(User object) {
		ensureHasAccount(object);
		return super.put(object);
	}

	private static final AccountDao ACCOUNT_DAO = new AccountDao();

	private static void ensureHasAccount(final User user) {
		if (user.getAccount() == null) {
			Account account = new Account();
			account.setName("Account "
					+ Optional.fromNullable(user.getName()).or(
							String.valueOf(new Date().getTime())));
			ACCOUNT_DAO.put(account);
			user.setAccount(account);
		}
	}

}
