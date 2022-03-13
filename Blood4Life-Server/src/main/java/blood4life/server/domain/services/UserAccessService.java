package blood4life.server.domain.services;

import blood4life.commons.domain.User;
import blood4life.server.access.users.IUserRepository;

public class UserAccessService {
    private IUserRepository repo;

    public UserAccessService(IUserRepository repo) {
        this.repo = repo;
    }

    public synchronized User login(int id, String password) {
        return repo.login(id, password);
    } 

    public synchronized String signup (int id, String password) {
        return repo.signup(id, password);
    }
}
