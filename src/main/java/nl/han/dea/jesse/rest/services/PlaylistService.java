package nl.han.dea.jesse.rest.services;

import jakarta.enterprise.context.ApplicationScoped;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import nl.han.dea.jesse.rest.services.dto.PlayListCollectionDTO;

@ApplicationScoped
public class PlaylistService {

    PlayListCollectionDTO playlists;


    public PlaylistService(){
        playlists = new PlayListCollectionDTO();
    }

    public PlayListCollectionDTO getAll() {
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
