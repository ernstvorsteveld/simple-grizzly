package nl.vorstdev.contract;

import com.example.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String alive();

    @GET
    @Path("echo")
    public String echo(@QueryParam("echo") String value);

    @GET
    @Path("object")
    public Person person();
}
