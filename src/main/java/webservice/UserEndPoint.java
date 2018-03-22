package webservice;

import Logic.users.UserBeanInt;
import com.google.gson.Gson;
import entities.users.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by error on 3/21/18.
 */
@Path("/user")
public class UserEndPoint {

    @EJB
    private UserBeanInt userBean;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(String s){

        Gson gson = new Gson();
        User user = gson.fromJson(s,User.class);

        if (userBean.addUser(user)){
            return Response
                    .status(200)
                    .entity("User id:" + user.getUserId() + " Added SuccessFully")
                    .build();
        }

        return Response.status(304).entity("Failed").build();


    }
    @POST
    @Path("/credentials")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response logInUser(@FormParam("userId") String userId, @FormParam("password") String password){

        if (userBean.logUser(userId,password)){

            return Response
                    .status(200)
                    .entity("Ok")
                    .build();
        }
        return Response.status(304).entity("Username or Password Wrong").build();



    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){

        List list = userBean.getAllUsers();
        if (list.size()>0){
            return Response.status(200).entity(new Gson().toJson(list)).build();

        }

        return Response.status(200).entity("No users").build();


    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String id){

        User user = userBean.getUser(id);

        if (user != null){

            return Response
                    .status(200)
                    .entity(user)
                    .build();
        }

        return Response
                .status(304)
                .entity("Failed to get user with id " + id)
                .build();



    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserDetails(@PathParam("userId") String id, String s){

        Gson gson = new Gson();
        User user = gson.fromJson(s,User.class);

        if (userBean.updateUser(id,user) != null){
            return Response.status(200).entity(new Gson().toJson(userBean.updateUser(id,user))).build();


        }
        return Response.status(304).entity("Failed").build();


    }

    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") String id){

        User user = userBean.deleteUser(id);
        if (user != null){
            return Response
                    .status(200)
                    .entity(new Gson().toJson(user))
                    .build();
        }
        return Response.status(304).entity("Failed to delete user id " + id ).build();


    }
}
