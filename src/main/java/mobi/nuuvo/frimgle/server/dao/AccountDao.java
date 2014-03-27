package mobi.nuuvo.frimgle.server.dao;

import mobi.nuuvo.frimgle.shared.domain.Account;

/**
 * The Class AccountDao.
 */
public class AccountDao extends BaseDao<Account> {

    /**
     * Instantiates a new account dao.
     */
    public AccountDao() {
        super(Account.class);
    }
}
