package blood4life.User.access.Users;

import blood4life.commons.domain.User;

public interface IUserAccess {
    
    public User logInUser(String id, String pw) throws Exception;

}
