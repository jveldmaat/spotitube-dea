package nl.han.dea.jesse.rest.services;

import jakarta.enterprise.context.ApplicationScoped;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import nl.han.dea.jesse.rest.services.dto.PlayListsDTO;
import nl.han.dea.jesse.rest.services.exeptions.PlayListNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PlaylistService {

    PlayListsDTO playlists;


    public PlaylistService(){
        playlists = new PlayListsDTO();
    }

    public PlayListsDTO getAll() {
        return playlists;
    }


    public void addSong(PlayListDTO songDTO) {

    }
    public PlayListDTO deleteSong(int id) {
        return null;
    }

    public void addPlaylist(PlayListDTO playListDTO){
        //playlists.addPLaylist(playListDTO);
    }

    public void addVideo(PlayListDTO songDTO) {

    }
    public PlayListDTO getPlaylist(int id) {
       return playlists.getPlayList(id);
    }
    public void deletePlaylist(int id) {
        playlists.removePlaylist(id);
    }


    public void renamePlayList(int id, PlayListDTO playlistDTO) {
        playlists.renamePlayList(id, playlistDTO);
    }
}
