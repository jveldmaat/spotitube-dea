package nl.han.dea.jesse.rest.services;

import nl.han.dea.jesse.rest.services.dto.PlayListDTO;

import java.util.List;

public interface PlaylistService {

    List<PlayListDTO> getAll();


    /* Song control */
    void addSong(PlayListDTO songDTO);

    PlayListDTO deleteSong(int id);

    /* Video control */

    void addVideo(PlayListDTO songDTO);

    PlayListDTO deleteVideo(int id);
}
