package nl.han.dea.jesse.rest.services.dto;

import java.time.LocalDate;
import java.util.Date;

public class VideoDTO extends TrackDTO{
    private LocalDate publicatiedatum;
    private String beschrijving;

    public VideoDTO(String performer, String titel, String url, float afspeelduur, LocalDate publicatiedatum, String beschrijving) {
        super(performer, titel, url, afspeelduur);
        this.publicatiedatum = publicatiedatum;
        this.beschrijving = beschrijving;
    }
}
