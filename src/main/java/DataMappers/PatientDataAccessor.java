package DataMappers;

import entities.users.Patient;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
public class PatientDataAccessor implements Crud {
    private EntityManager em;

    public PatientDataAccessor(EntityManager em) {
        this.em = em;
    }

    @Override
    public Patient create(Object o) {
        Patient patient = (Patient) o;

        try{
            em.persist(patient);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return patient;
    }

    @Override
    public Patient read(String id){
        Patient patient;

        try{
            patient  = em.find(Patient.class,id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return patient;
    }

    @Override
    public Patient delete(String id) {
        Patient patient = null;
        try{
            patient = em.find(Patient.class,id);

            if (patient != null){
                em.remove(patient);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient update(String id, Object o) {
        Patient patientDb = null;
        Patient patientPsd = (Patient) o;

        try{
            patientDb = em.find(Patient.class,id);
            if (patientDb != null){

                patientDb.setAddress(patientPsd.getAddress());
                patientDb.setAge(patientPsd.getAge());
                patientDb.setGender(patientPsd.getGender());
                patientDb.setName(patientPsd.getName());
                patientDb.setRegId(patientPsd.getRegId());
                em.merge(patientDb);

            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return patientDb;
    }


    @Override
    public List getAll() {
        String sql = "select p from Patient p";
        return em.createQuery(sql,Patient.class).getResultList();
    }
}
