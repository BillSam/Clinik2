package Logic.users;

import DataMappers.UserDataAccessor;
import entities.users.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by error on 3/21/18.
 */
@Stateless
public class UserBeanLogic implements UserBeanInt {

    @PersistenceContext
    private EntityManager entityManager;
    private UserDataAccessor dataAccessor = null;


    public UserBeanLogic() {
         dataAccessor = new UserDataAccessor(entityManager);
    }

    @Override
    public boolean addUser(User user) {

        if (dataAccessor.create(user) != null){
            return true;
        }
        return false;

    }

    @Override
    public User getUser(String id) {

        User user = dataAccessor.read(id);

        if (user != null){
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(String id, User user) {

        User user1 = null;
        if (dataAccessor.update(id,user) != null){
            user1 = dataAccessor.update(id,user);

        }
        return user1;
    }

    @Override
    public User deleteUser(String id) {

        User user1 = null;

        if (dataAccessor.delete(id) != null){

            user1 =  dataAccessor.delete(id);
        }

        return user1;
    }

    @Override
    public List getAllUsers() {
        return dataAccessor.getAll();
    }

    @Override
    public boolean logUser(String id, String passwd) {
        User userDb = getUser(id);
        if (userDb != null){
            if (userDb.getPassword().equals(passwd) && userDb.getUserId().equals(id)){

                return true;
            }
        }
        return false;

    }
}
