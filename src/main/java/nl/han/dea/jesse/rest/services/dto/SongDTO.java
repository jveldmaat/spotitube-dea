package nl.han.dea.jesse.rest.services.dto;

import java.sql.Time;

public class SongDTO extends TrackDTO{
    private String album;

    public SongDTO(String performer, String titel, String url, float afspeelduur, String album){
        super(performer, titel, url, afspeelduur);
        this.album = album;
    }
}
