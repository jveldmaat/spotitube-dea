package nl.han.dea.jesse.rest.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.datasource.PlaylistDAO;
import nl.han.dea.jesse.rest.datasource.UserDAO;
import nl.han.dea.jesse.rest.services.PlaylistService;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;

import javax.print.attribute.standard.Media;
import java.net.URI;

import static jakarta.ws.rs.core.Response.*;

@Path("/playlists")
public class PlaylistResource {

    private UserDAO user;
    private PlaylistDAO playlists;
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Response getPlaylists(@QueryParam("token") String token){
        if(token.equals(user.getToken(token))){
            return ok(playlists.getAll()).build();
        }

        return ok(401).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    @Path("/{id}/tracks")
    public Response getPlaylist(@PathParam("id")int id){
        return ok(/*playlists.getPlaylist(id)*/).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deletePlaylist(@PathParam("id") int id){
        //playlists.deletePlaylist(id);
        return ok(200).entity(playlists.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(PlayListDTO playListDTO){
        playListDTO.setOwner(true);
        playlists.addPlaylist(playListDTO);
        return ok(200).entity(playlists.getAll()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPlaylist(@QueryParam("token") String token, @PathParam("id") int id, PlayListDTO playlistDTO){
        if(id != playlistDTO.getId() || !"1234-1234".equals(token)){
            return status(37).build();
        } else{
            //playlists.renamePlayList(id, playlistDTO);
        }
        return ok().build();
    }


    @Inject
    public void setPlaylistService(PlaylistDAO playlists){
        this.playlists = playlists;
    }

    @Inject
    public void setUserDAO(UserDAO userDAO){
        this.user = userDAO;
    }
}
