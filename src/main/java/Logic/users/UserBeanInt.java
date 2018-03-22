package Logic.users;

import entities.users.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by error on 3/21/18.
 */
@Local
public interface UserBeanInt {

    boolean addUser(User user);
    User getUser(String id);
    User updateUser(String id, User user);
    User deleteUser(String id);
    List getAllUsers();
    boolean logUser(String id, String passwd);

}
