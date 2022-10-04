package nl.han.dea.jesse.rest.services.dto;

import java.sql.Time;

public class TrackDTO {
    private String performer;
    private String titel;
    private String url;
    private long afspeelduur;
    private boolean offlineAvailable;

    public TrackDTO(String performer, String titel, String url, long afspeelduur, boolean offlineAvailable) {
    this.performer = performer;
    this.titel = titel;
    this.url = url;
    this.afspeelduur = afspeelduur;
    this.offlineAvailable = offlineAvailable;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return titel;
    }

    public void setTitle(String titel) {
        this.titel = titel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuration() {
        return afspeelduur;
    }

    public void setDuration(long afspeelduur) {
        this.afspeelduur = afspeelduur;
    }

    public boolean isOfflineAvailable() {
        return offlineAvailable;
    }
}
