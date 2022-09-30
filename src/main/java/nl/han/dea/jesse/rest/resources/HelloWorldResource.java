package nl.han.dea.jesse.rest.resources;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HelloWorldResource {

    @GET
    public String HelloWorld(){
        return "Hello World";
    }
}
