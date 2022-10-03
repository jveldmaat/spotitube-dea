package nl.han.dea.jesse.rest.services.dto;

import java.sql.Time;

public class TrackDTO {
    private String performer;
    private String titel;
    private String url;
    private float afspeelduur;

    public TrackDTO(String performer, String titel, String url, float afspeelduur) {
    this.performer = performer;
    this.titel = titel;
    this.url = url;
    this.afspeelduur = afspeelduur;
    }
}
