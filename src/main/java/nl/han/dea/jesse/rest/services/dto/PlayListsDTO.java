package nl.han.dea.jesse.rest.services.dto;

import nl.han.dea.jesse.rest.datasource.PlaylistDAO;
import nl.han.dea.jesse.rest.services.exeptions.PlayListNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayListsDTO {

    //private List<PlayListDTO> playlists;
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private long length;

    public PlayListsDTO(){
    }

    public PlayListDTO getPlayList(int id){
        Optional<PlayListDTO> requestedPlaylist = playlistDAO.getAll().stream().filter(item -> item.getId() == id).findFirst();

        if (requestedPlaylist.isPresent()) {
            return requestedPlaylist.get();
        } else {
            throw new PlayListNotAvailableException();
        }
    }

    public void removePlaylist(int id){
        Optional<PlayListDTO> playlistForName = playlistDAO.getAll().stream().filter(item -> item.getId() == id).findFirst();

        List<PlayListDTO> filteredPlaylists = playlistDAO.getAll().stream().filter(item -> item.getId() != id).collect(Collectors.toList());

        if (filteredPlaylists.size() == playlistDAO.getAll().size()) {
            throw new PlayListNotAvailableException();
        }

        playlistDAO.setAll(filteredPlaylists);
    }


    public List<PlayListDTO> getPlaylists(){
        return playlistDAO.getAll();
    }

    public void addPLaylist(PlayListDTO playListDTO, String token){
        playlistDAO.addPlaylist(playListDTO, token);
    }

    public void renamePlayList(int id, PlayListDTO playlistDTO) {

    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
