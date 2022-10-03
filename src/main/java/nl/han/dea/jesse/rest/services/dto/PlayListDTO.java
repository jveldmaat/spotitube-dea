package nl.han.dea.jesse.rest.services.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayListDTO {
    private int id;
    private String naam;
    private boolean eigenaar;

    private List<TrackDTO> tracks = new ArrayList<>();

    public PlayListDTO(int id, String naam, boolean eigenaar){
        this.id = id;
        this.naam = naam;
        this.eigenaar = eigenaar;
        tracks.add(new SongDTO("Infected Mushrooms", "Here We Go Go Go", "https://open.spotify.com/track/5wTudWQXd6Sjy6nH22fsYv?si=b3cf0117a54c4971", (float) 5.55, "Head of Nasa and the 2 Amish Boys"));
        tracks.add(new VideoDTO("Marc Rebillet","rainy sunday", "https://www.youtube.com/watch?v=lNoHWs9KKNs", (float) 120.40, LocalDate.parse("2022-10-03"), "rainy sunday vibes" ));
    }
}
