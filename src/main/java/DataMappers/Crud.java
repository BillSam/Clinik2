package DataMappers;

import java.util.List;

/**
 * Created by error on 3/21/18.
 */
public interface Crud {

    Object create(Object o);
    Object read(String id);
    Object delete(String id);
    Object update(String id,Object o);
    List getAll();

}
