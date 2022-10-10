package nl.han.dea.jesse.rest.datasource;

import jakarta.inject.Inject;
import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.dto.PlayListDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaylistDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
    private long length;
    private DatabaseProperties databaseProperties;

    public PlaylistDAO(){
    }

    public List<PlayListDTO> getAll() {
        List<PlayListDTO> playlists = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from playlists");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                length += 10;
                PlayListDTO playlist = new PlayListDTO(resultSet.getInt("id"), resultSet.getString("name"));
                playlists.add(playlist);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return playlists;
    }

    public void setAll(List<PlayListDTO> filteredPlaylists) {
    }

    public void addPlaylist(PlayListDTO playListDTO) {
    }

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
