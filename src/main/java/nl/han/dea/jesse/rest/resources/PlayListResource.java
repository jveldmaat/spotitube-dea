package nl.han.dea.jesse.rest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.ok;

@Path("/playlists")
public class PlayListResource {


    @GET
    @Produces("application/json")
    public Response getPlaylists(@QueryParam("token") String token){
        if(token.equals("1234-1234")){
            //var response =
        }
        token = "1234-1234";

        return ok(token).build();
    }
}
