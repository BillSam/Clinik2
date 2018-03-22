package entities.actions;

import entities.users.Patient;
import entities.users.Pharmacist;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by error on 2/6/18.
 */

public class Dispense {



    private String dispenceId;
    private String patientId;
    private String pharmacistId;
    private String drugs;
    private String time;
    private String date;

    public String getDispenceId() {
        return dispenceId;
    }

    public void setDispenceId(String dispenceId) {
        this.dispenceId = dispenceId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(String pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
