package nl.han.dea.jesse.rest.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.datasource.TracksDAO;
import nl.han.dea.jesse.rest.services.dto.TrackCollectionDTO;

import static jakarta.ws.rs.core.Response.ok;

@Path("/tracks")
public class TracksResource {

    TracksDAO tracksDAO;

    @GET
    public Response getAvailableTracks(@QueryParam("forPlaylist") int id, @QueryParam("token") String token){
        TrackCollectionDTO trackCollectionDTO = new TrackCollectionDTO();
        trackCollectionDTO.setTracks(tracksDAO.getAvailableTracks(id));
        return ok(trackCollectionDTO).build();
    }

    @Inject
    public void setTracksDAO(TracksDAO tracksDAO){
        this.tracksDAO = tracksDAO;
    }
}
