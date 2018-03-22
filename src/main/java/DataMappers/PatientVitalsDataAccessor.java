package DataMappers;

import entities.actions.PatientVitals;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
public class PatientVitalsDataAccessor implements Crud {
    private EntityManager em;

    public PatientVitalsDataAccessor(EntityManager em) {
        this.em = em;
    }

    @Override
    public PatientVitals create(Object o) {
        PatientVitals vitals = (PatientVitals) o;

        try{
            em.persist(vitals);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return vitals;
    }

    @Override
    public PatientVitals read(String id) {
        PatientVitals vitals = null;
        try{
            vitals = em.find(PatientVitals.class,id);

        }catch (Exception e){
            e.printStackTrace();

        }

        return vitals;
    }

    @Override
    public PatientVitals delete(String id) {
        PatientVitals vitals = null;
        try{
            vitals = em.find(PatientVitals.class,id);
            if (vitals != null){
                em.remove(vitals);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return vitals;
    }

    @Override
    public PatientVitals update(String id, Object o) {
        PatientVitals vitalsDb = null;
        PatientVitals vitalsPsd = (PatientVitals) o;
        try {
            vitalsDb = em.find(PatientVitals.class,id);
            if (vitalsDb != null){


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return vitalsDb;
    }

    @Override
    public List getAll() {
        String sql = "SELECT v from PatientVitals v";
        return em.createQuery(sql).getResultList();
    }
}
