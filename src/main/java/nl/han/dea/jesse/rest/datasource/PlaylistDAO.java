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
    UserDAO user;
    private DatabaseProperties databaseProperties;

    public PlaylistDAO(){
    }

    public List<PlayListDTO> getAll() {
        List<PlayListDTO> playlists = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from playlists");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PlayListDTO playlist = new PlayListDTO();
                playlist.setId(resultSet.getInt("id"));
                playlist.setName(resultSet.getString("name"));
                playlist.setEigenaarNaam(resultSet.getString("owner"));
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

    public void addPlaylist(PlayListDTO playListDTO, String token) {
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO playlists (name, owner) " + "values(?,?)");
            statement.setString(1, playListDTO.getName());
            statement.setString(2, user.findUser(token).getUser());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }

    public void deletePlaylist(int id){
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM track_in_playlists where playlistsid = ?");
            statement.setInt(1, id);
            statement.execute();
            statement = connection.prepareStatement("DELETE FROM playlists where id = ?");
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
    }



    public long getLength() {
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("select * from playlists p inner join track_in_playlists tip on p.id = tip.playlistsid inner join tracks t on tip.trackid = t.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                length += resultSet.getLong("afspeelduur");
            }
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return length;
    }

    public void renamePlayList(int id, PlayListDTO playListDTO){
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("UPDATE playlists set name = ? where id = ?");
            statement.setString(1,playListDTO.getName());
            statement.setInt(2,id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }

    }
    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    @Inject
    public void setUserDAO(UserDAO userDAO){
        this.user = userDAO;
    }
}
