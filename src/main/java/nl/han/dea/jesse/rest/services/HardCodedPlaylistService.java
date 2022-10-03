package nl.han.dea.jesse.rest.services;

import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import nl.han.dea.jesse.rest.services.dto.TrackDTO;

import java.util.ArrayList;
import java.util.List;

public class HardCodedPlaylistService implements PlaylistService{

    private List<PlayListDTO> playLists = new ArrayList<>();

    public HardCodedPlaylistService(){
        playLists.add(new PlayListDTO(1,"Random dingen", true));

    }
    @Override
    public List<PlayListDTO> getAll() {
        return playLists;
    }

    @Override
    public void addSong(PlayListDTO songDTO) {

    }

    @Override
    public PlayListDTO deleteSong(int id) {
        return null;
    }

    @Override
    public void addVideo(PlayListDTO songDTO) {

    }

    @Override
    public PlayListDTO deleteVideo(int id) {
        return null;
    }
}
