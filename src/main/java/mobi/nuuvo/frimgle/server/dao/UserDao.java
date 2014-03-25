package mobi.nuuvo.frimgle.server.dao;

import mobi.nuuvo.frimgle.shared.domain.User;

public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User findByGoogleId(String googleId) {
        return query().filter("googleId =", googleId).first().now();
    }
}
