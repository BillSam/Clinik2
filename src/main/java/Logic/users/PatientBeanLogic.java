package Logic.users;

import DataMappers.PatientDataAccessor;
import entities.users.Patient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
public class PatientBeanLogic implements PatientBeanInt{
    @PersistenceContext
    private EntityManager entityManager;

    private PatientDataAccessor patientDataAccessor = null;
    public PatientBeanLogic() {
        patientDataAccessor = new PatientDataAccessor(entityManager);
    }

    @Override
    public boolean addPatient(Patient patient) {
        if (patientDataAccessor.create(patient) != null){
            return true;
        }
        return false;
    }

    @Override
    public Patient getPatient(String id) {

        Patient patient = new Patient();

        if (patientDataAccessor.read(id) != null){
            patient = patientDataAccessor.read(id);
        }

        return patient;

    }

    @Override
    public Patient updatePatient(String id, Patient patient) {
        Patient patient1 = null;
        if (patientDataAccessor.update(id,patient) != null){
            patient1 = patientDataAccessor.update(id,patient);
        }

        return patient1;
    }

    @Override
    public Patient deletePatient(String id) {
        Patient patient = null;
        if (patientDataAccessor.delete(id) != null){
            patient = patientDataAccessor.delete(id);
        }
        return patient;
    }

    @Override
    public List getAllPatients() {
        return patientDataAccessor.getAll();
    }
}
