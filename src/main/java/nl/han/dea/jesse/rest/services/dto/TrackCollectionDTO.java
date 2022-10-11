package nl.han.dea.jesse.rest.services.dto;

import java.util.ArrayList;
import java.util.List;

public class TrackCollectionDTO {
    private List<TrackDTO> tracks = new ArrayList<>();

    public TrackCollectionDTO(){
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }
}
