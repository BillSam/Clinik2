package entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/12/18.
 */

public class Nurse extends User {


    private String nurseId;

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }
}
