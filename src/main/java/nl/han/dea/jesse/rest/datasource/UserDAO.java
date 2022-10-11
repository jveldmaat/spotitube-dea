package nl.han.dea.jesse.rest.datasource;


import jakarta.inject.Inject;
import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.dto.LoginResponseDTO;
import nl.han.dea.jesse.rest.services.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jakarta.ws.rs.core.Response.ok;

public class UserDAO {
    private Logger logger = Logger.getLogger(getClass().getName());

    private DatabaseProperties databaseProperties;


    public List<UserDTO> findAll(Connection connection) {
        List<UserDTO> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserDTO user = new UserDTO(resultSet.getString("user"), resultSet.getString("password"), resultSet.getString("token"));
                users.add(user);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return users;
    }

    public LoginResponseDTO login(String username){
        LoginResponseDTO login = null;
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())){
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            login = new LoginResponseDTO(
                    resultSet.getString("username"),
                    resultSet.getString("token")
            );
        }

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("HAHA LOSER");
        }
        return login;
    }

    public String getToken(String token) {
        String getToken = null;
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE token = ?");
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                getToken = resultSet.getString("token");
                System.out.println(getToken);
            }
            statement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("HAHA LOSER");
        }
        return getToken;
    }
    
    public UserDTO findUser(String token){
        UserDTO user = null;
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from users where token = ?");
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                user = new UserDTO(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("token"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionString(), e);
        }
        return user;
    }

//    public boolean deleteItem(int id) {
//        try (Connection connection = DriverManager.getConnection(databaseProperties.connectionString())) {
//            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
//            statement.setInt(1, id);
//            return statement.execute();
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Can't delete item with id " + id, e);
//        }
//        return false;
//    }

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }


}