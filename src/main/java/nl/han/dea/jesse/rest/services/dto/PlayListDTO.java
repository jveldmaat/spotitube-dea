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

//    public PlayListDTO(int id, String naam, boolean eigenaar){
//        this.id = id;
//        this.naam = naam;
//        this.eigenaar = eigenaar;
//        tracks.add(new SongDTO("Infected Mushrooms", "Here We Go Go Go", "https://open.spotify.com/track/5wTudWQXd6Sjy6nH22fsYv?si=b3cf0117a54c4971", 500, "Head of Nasa and the 2 Amish Boys", false));
//        tracks.add(new VideoDTO("Marc Rebillet","rainy sunday", "https://www.youtube.com/watch?v=lNoHWs9KKNs", 500, LocalDate.parse("2022-10-03"), "rainy sunday vibes", true ));
//    }
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return naam;
    }
    public boolean getOwner(){
        return eigenaar;
    }

    public List<TrackDTO> getTracks(){
        return tracks;
    }

    public void setName(String name){
        this.naam = name;
    }

    public void setOwner(boolean eigenaar){
        this.eigenaar = eigenaar;
    }
}
