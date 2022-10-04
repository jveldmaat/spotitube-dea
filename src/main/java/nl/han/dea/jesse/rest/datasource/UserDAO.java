package nl.han.dea.jesse.rest.datasource;


import jakarta.inject.Inject;
import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;


    public List<UserDTO> findAll(Connection connection) {
        List<UserDTO> users = new ArrayList<>();
        try {
            //Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement statement = connection.prepareStatement("SELECT * from users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserDTO user = new UserDTO(resultSet.getString("user"), resultSet.getString("passowrd"));
                users.add(user);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return users;
    }

    public boolean deleteItem(int id) {
        try (Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Can't delete item with id " + id, e);
        }
        return false;
    }

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }
}