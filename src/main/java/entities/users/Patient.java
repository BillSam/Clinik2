package entities.users;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/6/18.
 */
@Entity
public class Patient {

    @Id
    private String regId;
    private int age;
    private String name;
    private String gender;
    private String address;

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
