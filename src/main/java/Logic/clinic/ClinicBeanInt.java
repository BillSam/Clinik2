package Logic.clinic;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
@Local
public interface ClinicBeanInt {
    boolean add(Object o);
    Object get(String id);
    boolean remove(String id);
    Object update(String id,Object o);
    List  getAll();
}
