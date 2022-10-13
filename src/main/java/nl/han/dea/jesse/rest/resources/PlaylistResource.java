package nl.han.dea.jesse.rest.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.datasource.PlaylistDAO;
import nl.han.dea.jesse.rest.datasource.TracksDAO;
import nl.han.dea.jesse.rest.datasource.UserDAO;
import nl.han.dea.jesse.rest.services.dto.PlayListCollectionDTO;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import nl.han.dea.jesse.rest.services.dto.TrackCollectionDTO;
import nl.han.dea.jesse.rest.services.dto.UserDTO;

import static jakarta.ws.rs.core.Response.*;

@Path("/playlists")
public class PlaylistResource {

    private UserDAO user;
    private PlaylistDAO playlistDAO;
    private TracksDAO tracksDAO;
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    public Response getPlaylists(@QueryParam("token") String token){
        if(token.equals(user.getToken(token))){
            UserDTO currentUser = user.findUser(token);
            PlayListCollectionDTO playListCollectionDTO = new PlayListCollectionDTO();
            playListCollectionDTO.setPlaylists(playlistDAO.getAll());
            playListCollectionDTO.setLength(playlistDAO.getLength());
            for(PlayListDTO playlists : playListCollectionDTO.getPlaylists()){
                if(playlists.getEigenaarNaam().equals(currentUser.getUser())){
                    playlists.setOwner(true);
                }
            }
            return ok(playListCollectionDTO).build();
        }
        return ok(401).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    @Path("/{id}/tracks")
    public Response getPlaylist(@PathParam("id")int id){
        TrackCollectionDTO trackCollectionDTO = new TrackCollectionDTO();
        trackCollectionDTO.setTracks(tracksDAO.getPlaylist(id));
        return ok(trackCollectionDTO).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deletePlaylist(@QueryParam("token") String token,@PathParam("id") int id){
        PlayListCollectionDTO playListCollectionDTO = new PlayListCollectionDTO();
        playlistDAO.deletePlaylist(id);
        if (token.equals(user.getToken(token))){
            UserDTO currentUser = user.findUser(token);
            playListCollectionDTO.setPlaylists(playlistDAO.getAll());
            playListCollectionDTO.setLength(playlistDAO.getLength());
            for (PlayListDTO playlists : playListCollectionDTO.getPlaylists()) {
                if (playlists.getEigenaarNaam().equals(currentUser.getUser())) {
                    playlists.setOwner(true);
                }
            }
        }
        return ok(200).entity(playListCollectionDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token, PlayListDTO playListDTO) {
        PlayListCollectionDTO playListCollectionDTO = new PlayListCollectionDTO();
        playlistDAO.addPlaylist(playListDTO, token);
        if (token.equals(user.getToken(token))) {
            UserDTO currentUser = user.findUser(token);
            playListCollectionDTO.setPlaylists(playlistDAO.getAll());
            playListCollectionDTO.setLength(playlistDAO.getLength());
            for (PlayListDTO playlists : playListCollectionDTO.getPlaylists()) {
                if (playlists.getEigenaarNaam().equals(currentUser.getUser())) {
                    playlists.setOwner(true);
                }
            }
        }
        return ok(201).entity(playListCollectionDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPlaylist(@QueryParam("token") String token, @PathParam("id") int id, PlayListDTO playlistDTO){
        PlayListCollectionDTO playListCollectionDTO = new PlayListCollectionDTO();
        if(id != playlistDTO.getId() || !token.equals(user.getToken(token))){
            return status(37).build();
        } else{
            playlistDAO.renamePlayList(id, playlistDTO);
            UserDTO currentUser = user.findUser(token);
            playListCollectionDTO.setPlaylists(playlistDAO.getAll());
            playListCollectionDTO.setLength(playlistDAO.getLength());
            for (PlayListDTO playlists : playListCollectionDTO.getPlaylists()) {
                if (playlists.getEigenaarNaam().equals(currentUser.getUser())) {
                    playlists.setOwner(true);
                }
            }
        }
        return ok(playListCollectionDTO).build();
    }

    @POST
    @Path("/{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrackToPlaylist(@QueryParam("token") String token){
        if(token.equals(user.getToken(token))) {
        }
        return ok(403).build();
    }


    @Inject
    public void setPlaylistService(PlaylistDAO playlistDAO){
        this.playlistDAO = playlistDAO;
    }

    @Inject
    public void setUserDAO(UserDAO userDAO){
        this.user = userDAO;
    }

    @Inject
    public void setTracksDAO(TracksDAO tracksDAO){
        this.tracksDAO = tracksDAO;
    }
}
