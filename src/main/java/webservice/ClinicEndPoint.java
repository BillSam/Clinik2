package webservice;

import Logic.clinic.ClinicBeanInt;
import com.google.gson.Gson;
import entities.actions.Booking;
import entities.actions.PatientVitals;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by error on 3/22/18.
 */
@Path("/clinic")
public class ClinicEndPoint {
    @EJB(mappedName = "bookingBean")
    private ClinicBeanInt bookingBean;

    @EJB(mappedName = "patientVitals")
    private ClinicBeanInt vitalsBean;

    @POST
    @Path("/book")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBooking(String s){
        Gson gson = new Gson();
        Booking booking = gson.fromJson(s,Booking.class);
        if (bookingBean.add(booking)){
            return Response
                    .status(200)
                    .entity("Saved Successffully")
                    .build();
        }
        return Response.status(304).entity("Failed").build();
    }

    @GET
    @Path("/book/{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBooking(@PathParam("bookId") String id){
        Booking booking = (Booking) bookingBean.get(id);
        booking = (Booking) bookingBean.get(id);

        if (bookingBean.get(id) != null){
            return Response
                    .status(200)
                    .entity(booking)
                    .build();
        }
        return Response.status(304).entity("Failed").build();
    }


    @POST
    @Path("/vitals")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPatientVitals(String s){
        Gson gson = new Gson();
        PatientVitals vitals = gson.fromJson(s,PatientVitals.class);
        if (vitalsBean.add(vitals)){
            return Response
                    .status(200)
                    .entity("Saved Successffully")
                    .build();
        }
        return Response.status(304).entity("Failed").build();
    }






}
