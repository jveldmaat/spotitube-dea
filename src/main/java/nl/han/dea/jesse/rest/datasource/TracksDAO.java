package nl.han.dea.jesse.rest.datasource;

import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import nl.han.dea.jesse.rest.services.dto.TrackDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TracksDAO {

    private Logger logger = Logger.getLogger(getClass().getName());
    private long length;
    private DatabaseProperties databaseProperties;

    public List<TrackDTO> getPlaylist(int id) {
        List<TrackDTO> tracks = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("select * from tracks t inner join track_in_playlists tip ON t.id=tip.trackid where playlistsid = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TrackDTO track = new TrackDTO(resultSet.getString("performer"), resultSet.getString("titel"), resultSet.getString("url"),resultSet.getLong("afspeelduur"),resultSet.getBoolean("offlineavailable"),resultSet.getString("album"),resultSet.getDate("publicatiedatum"),resultSet.getString("beschrijving"));
                tracks.add(track);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return tracks;
    }

}
