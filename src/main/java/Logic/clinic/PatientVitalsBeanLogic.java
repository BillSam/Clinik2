package Logic.clinic;

import DataMappers.PatientVitalsDataAccessor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
@Stateless(mappedName = "patientVitals")
public class PatientVitalsBeanLogic implements ClinicBeanInt {
    @PersistenceContext
    private EntityManager entityManager;
    private PatientVitalsDataAccessor dataAccessor;

    public PatientVitalsBeanLogic() {
        this.dataAccessor = new PatientVitalsDataAccessor(entityManager);
    }
    @Override
    public boolean add(Object o) {
        return true;
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public boolean remove(String id) {
        return true;
    }

    @Override
    public Object update(String id, Object o) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
