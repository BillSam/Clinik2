package entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/9/18.
 */

public class Receptionist extends User {

    private String recpId;

    public String getRecpId() {
        return recpId;
    }

    public void setRecpId(String recpId) {
        this.recpId = recpId;
    }
}
