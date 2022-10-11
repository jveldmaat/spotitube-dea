package nl.han.dea.jesse.rest.services.dto;

import java.sql.Date;
import java.time.LocalDate;

public class TrackDTO {
    private String performer;
    private String titel;
    private String url;
    private long afspeelduur;
    private boolean offlineAvailable;
    private String album;

    private Date publicatiedatum;
    private String beschrijving;

    public TrackDTO(String performer, String titel, String url, long afspeelduur, boolean offlineAvailable, String album, Date publicatiedatum, String beschrijving) {
    this.performer = performer;
    this.titel = titel;
    this.url = url;
    this.afspeelduur = afspeelduur;
    this.offlineAvailable = offlineAvailable;
    this.album = album;
    this.publicatiedatum = publicatiedatum;
    this.beschrijving = beschrijving;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Date getPublicatiedatum() {
        return publicatiedatum;
    }

    public void setPublicatiedatum(Date publicatiedatum) {
        this.publicatiedatum = publicatiedatum;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
