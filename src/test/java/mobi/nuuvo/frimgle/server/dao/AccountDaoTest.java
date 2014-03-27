package mobi.nuuvo.frimgle.server.dao;

import mobi.nuuvo.frimgle.shared.domain.Account;

/**
 * The Class AccountDaoTest.
 */
public class AccountDaoTest extends AbstractDaoTest<Account, AccountDao> {

	/* (non-Javadoc)
	 * @see mobi.nuuvo.frimgle.server.dao.AbstractDaoTest#newEntity()
	 */
	@Override
	protected Account newEntity() {
		return new Account();
	}

	/* (non-Javadoc)
	 * @see mobi.nuuvo.frimgle.server.dao.AbstractDaoTest#newDao()
	 */
	@Override
	protected AccountDao newDao() {
		return new AccountDao();
	}

}
