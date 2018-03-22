package DataMappers;

import entities.actions.Booking;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
public class BookingDataAccessor implements Crud {

    private EntityManager em;

    public BookingDataAccessor(EntityManager em) {
        this.em = em;
    }

    @Override
    public Booking create(Object o) {
        Booking booking = (Booking) o;

        try{
            em.persist(booking);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return booking;
    }

    @Override
    public Booking read(String id) {
        Booking booking = null;
        try{
            booking = em.find(Booking.class,id);

        }catch (Exception e){
            e.printStackTrace();

        }

        return booking;
    }

    @Override
    public Booking delete(String id) {
        Booking booking = null;
        try{
            booking = em.find(Booking.class,id);
            if (booking != null){
                em.remove(booking);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return booking;
    }

    @Override
    public Booking update(String id, Object o) {
        Booking bookingDb = null;
        Booking bookingPsd = (Booking) o;
        try {
            bookingDb = em.find(Booking.class,id);
            if (bookingDb != null){
                bookingDb.setDoctorId(bookingPsd.getDoctorId());
                bookingDb.setPatientId(bookingPsd.getPatientId());
                bookingDb.setRoom(bookingPsd.getRoom());
                bookingDb.setDate(bookingPsd.getDate());
                bookingDb.setTime(bookingPsd.getTime());
                em.merge(bookingDb);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return bookingDb;
    }

    @Override
    public List getAll() {
        String sql = "SELECT b from Booking b";
        return em.createQuery(sql).getResultList();
    }
}
