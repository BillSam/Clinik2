package Logic.users;

import entities.users.Patient;

import java.util.List;

/**
 * Created by error on 3/22/18.
 */
public interface PatientBeanInt {
    boolean addPatient(Patient patient);
    Patient getPatient(String id);
    Patient updatePatient(String id, Patient patient);
    Patient deletePatient(String id);
    List getAllPatients();
}
