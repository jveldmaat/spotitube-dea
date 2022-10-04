package nl.han.dea.jesse.rest.services.dto;

import java.sql.Time;

public class SongDTO extends TrackDTO{
    private String album;

    public SongDTO(String performer, String titel, String url, long afspeelduur, String album, boolean offlineAvailable){
        super(performer, titel, url, afspeelduur, offlineAvailable);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
