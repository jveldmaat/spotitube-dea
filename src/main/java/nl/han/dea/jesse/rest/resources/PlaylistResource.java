package nl.han.dea.jesse.rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.ok;

@Path("/playlists")
public class PlaylistResource {


    @GET
    @Produces("application/json")
    public Response getPlaylists(@QueryParam("token") String token){
        if(token.equals("1234-1234")){
            //var response =
        }
        token = "1234-1234";

        return ok(token).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deletePlaylist(){
        return ok().build();
    }

    @Path("/{id}")
    @POST
    public Response addPlaylist(){

    }
}
