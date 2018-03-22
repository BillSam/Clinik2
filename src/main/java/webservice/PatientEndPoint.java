package webservice;

import Logic.users.PatientBeanInt;
import com.google.gson.Gson;
import entities.users.Patient;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by error on 3/22/18.
 */
@Path("/patient")
public class PatientEndPoint {
    @EJB
    private PatientBeanInt patientBean;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(String s){

        if (patientBean.addPatient(new Gson().fromJson(s, Patient.class))){
            return Response
                    .status(200)
                    .entity("Patient Added Successffull")
                    .build();
        }
        return Response
                .status(304)
                .entity("Failed")
                .build();



    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){

        List list = patientBean.getAllPatients();
        if (list.size()>0){
            return Response.status(200).entity(new Gson().toJson(list)).build();

        }

        return Response.status(200).entity("No Patients").build();


    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("patientId") String id){

        Patient patient = patientBean.getPatient(id);

        if (patient != null){

            return Response
                    .status(200)
                    .entity(patient)
                    .build();
        }

        return Response
                .status(304)
                .entity("Failed to get patient with id " + id)
                .build();



    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserDetails(@PathParam("patientId") String id, String s){

        Gson gson = new Gson();
        Patient patient = gson.fromJson(s,Patient.class);

        if (patientBean.updatePatient(id,patient) != null){
            return Response.status(200).entity(new Gson().toJson(patientBean.updatePatient(id,patient))).build();
        }
        return Response.status(304).entity("Failed").build();


    }

    @DELETE
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("patientId") String id){

        Patient patient = patientBean.deletePatient(id);
        if (patient != null){
            return Response
                    .status(200)
                    .entity(new Gson().toJson(patient))
                    .build();
        }
        return Response.status(304).entity("Failed to delete patient id " + id ).build();


    }

}
