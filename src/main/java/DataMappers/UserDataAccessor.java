package DataMappers;

import entities.users.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by error on 3/21/18.
 */
public class UserDataAccessor implements Crud {
    private EntityManager em;

    public UserDataAccessor(EntityManager e){
        this.em = e;
    }


    public User create(Object o){

        User user = (User) o;

        try{

            em.persist(user);
        }catch (Exception e){
            System.out.println(e);

        }
        return user;
    }

    public User read(String id) {
        User user;

        try{
            user  = em.find(User.class,id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return user;


    }

    public User delete(String id) {

        User user = null;
        try{
            user = em.find(User.class,id);

            if (user != null){
                em.remove(user);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public User update(String id, Object o){
        User userDb =null                                                                                                                                                                       ;
        User userPsd = (User) o;
        try{
            userDb = em.find(User.class,id);
            if (userDb != null){

                userDb.setAge(userPsd.getAge());
                userDb.setFname(userPsd.getFname());
                userDb.setLname(userPsd.getLname());
                userDb.setProfession(userPsd.getProfession());
                userDb.setUserId(userPsd.getUserId());
                em.merge(userDb);

                return userDb;

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return userDb;
    }

    @Override
    public List getAll() {
        String sql = "Select u from User u";
        return em.createQuery(sql,User.class).getResultList();
    }
}
