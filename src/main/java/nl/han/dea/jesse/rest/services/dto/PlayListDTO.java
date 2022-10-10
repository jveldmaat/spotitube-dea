package nl.han.dea.jesse.rest.services.dto;

import jakarta.enterprise.inject.Default;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayListDTO {
    private int id;
    private String naam;
    private boolean eigenaar;

    private List<TrackDTO> tracks = new ArrayList<>();

    public PlayListDTO(int id, String naam){
        this.id = id;
        this.naam = naam;
    }

    public PlayListDTO(){

    }

    public int getId(){
        return id;
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

    public void setId(int id){this.id = id;}

}
