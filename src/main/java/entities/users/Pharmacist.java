package entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/9/18.
 */

public class Pharmacist extends User {


    private String pharmId;

    public String getPharmId() {
        return pharmId;
    }

    public void setPharmId(String pharmId) {
        this.pharmId = pharmId;
    }
}
