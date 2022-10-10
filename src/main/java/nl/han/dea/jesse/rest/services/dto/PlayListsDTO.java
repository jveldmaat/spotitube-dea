package nl.han.dea.jesse.rest.services.dto;

import nl.han.dea.jesse.rest.services.exeptions.PlayListNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayListsDTO {

    private List<PlayListDTO> playlists = new ArrayList<>();

    private long length;

    public PlayListsDTO(){
        //playlists.add(new PlayListDTO(1,"Random dingen", true));
        //playlists.add(new PlayListDTO(2, "Metal", true));
        length = 500;
    }

    public PlayListDTO getPlayList(int id){
        Optional<PlayListDTO> requestedPlaylist = playlists.stream().filter(item -> item.getId() == id).findFirst();

        if (requestedPlaylist.isPresent()) {
            return requestedPlaylist.get();
        } else {
            throw new PlayListNotAvailableException();
        }
    }


    public List<PlayListDTO> getPlaylists(){
        return playlists;
    }

    public long getLength(){
        return length;
    }

    public void addPLaylist(PlayListDTO playListDTO){
        playlists.add(playListDTO);
    }

}
