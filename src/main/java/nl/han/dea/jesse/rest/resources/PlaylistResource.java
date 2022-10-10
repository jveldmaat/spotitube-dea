package nl.han.dea.jesse.rest.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.services.PlaylistService;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;

import java.net.URI;

import static jakarta.ws.rs.core.Response.created;
import static jakarta.ws.rs.core.Response.ok;

@Path("/playlists")
public class PlaylistResource {

    PlaylistService playlists;
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Response getPlaylists(@QueryParam("token") String token){
        if(token.equals("1234-1234")){
            return ok(playlists.getAll()).build();
        }

        return ok(401).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    @Path("/{id}/tracks")
    public Response getPlaylist(@PathParam("id")int id){
        return ok(playlists.getPlaylist(id)).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deletePlaylist(){
        return ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(PlayListDTO playListDTO){
        playlists.addPlaylist(playListDTO);
        return Response.status(200).entity(playlists.getAll()).build();
    }


    @Inject
    public void setPlaylistService(PlaylistService playlists){
        this.playlists = playlists;
    }
}
