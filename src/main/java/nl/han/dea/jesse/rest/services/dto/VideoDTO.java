package nl.han.dea.jesse.rest.services.dto;

import java.time.LocalDate;
import java.util.Date;

public class VideoDTO extends TrackDTO{
    private LocalDate publicatiedatum;
    private String beschrijving;

    public VideoDTO(String performer, String titel, String url, long afspeelduur, LocalDate publicatiedatum, String beschrijving, boolean offlineAvailable) {
        super(performer, titel, url, afspeelduur, offlineAvailable);
        this.publicatiedatum = publicatiedatum;
        this.beschrijving = beschrijving;
    }

    public LocalDate getPublicationDate() {
        return publicatiedatum;
    }

    public void setPublicationDate(LocalDate publicatiedatum) {
        this.publicatiedatum = publicatiedatum;
    }

    public String getDescription() {
        return beschrijving;
    }

    public void setDescription(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
