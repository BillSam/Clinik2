package entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/9/18.
 */
@Entity
public class User {

    @Id
    private String userId;
    private String fname;
    private String lname;
    private String password;
    private int age;
    private String profession;
    private boolean isLoggedIn;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
        /*try {
            this.password = encyrptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }*/
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    /*public static String encyrptPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] mesagedigest = md.digest(password.getBytes());
        BigInteger num = new BigInteger(1, mesagedigest);
        String hash = num.toString(16);
        while( hash.length() < 32){
            hash = "0"+hash;
        }
        return hash;
    }*/
}
