package Logic.clinic;

import DataMappers.BookingDataAccessor;
import entities.actions.Booking;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
@Stateless(mappedName = "bookingBean")
public class BookingBeanLogic implements ClinicBeanInt {
    @PersistenceContext
    private EntityManager entityManager;
    private BookingDataAccessor dataAccessor;

    public BookingBeanLogic() {
        this.dataAccessor = new BookingDataAccessor(entityManager);
    }

    @Override
    public boolean add(Object o) {
        Booking booking = (Booking) o;
        if (dataAccessor.create(booking) != null){
            return true;
        }

        return false;
    }

    @Override
    public Booking get(String id) {
        Booking booking = null;
        if (dataAccessor.read(id) != null){
            booking = dataAccessor.read(id);
        }

        return booking;
    }

    @Override
    public boolean remove(String id) {
        Booking booking = null;
        booking = dataAccessor.delete(id);
        if (booking != null)
            return true;


        return false;
    }

    @Override
    public Booking update(String id, Object o) {
        Booking booking = null;

        if (dataAccessor.update(id,booking) != null)
            return booking = dataAccessor.update(id,booking);

        return booking;
    }

    @Override
    public List getAll() {

        return dataAccessor.getAll();
    }
}
