package blood4life.server.access.users;

import blood4life.commons.domain.User;

public interface IUserRepository {
    public User login(int id, String password);
}
