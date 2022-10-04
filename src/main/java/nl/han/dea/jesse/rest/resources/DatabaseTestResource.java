package nl.han.dea.jesse.rest.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.datasource.UserDAO;
import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.PlaylistService;
import nl.han.dea.jesse.rest.services.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jakarta.ws.rs.core.Response.ok;

@Path("/database")
public class DatabaseTestResource {
    private Logger logger = Logger.getLogger(getClass().getName());

    private UserDAO user;

    private DatabaseProperties databaseProperties;

    @GET
    public Response getUsers(){
        try(Connection connection = DriverManager.getConnection(databaseProperties.connectionString());){
        user.findAll(connection);
        } catch(SQLException e){
            e.printStackTrace();
            return ok("niet gevonden").build();
        }
    }

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties){
        this.databaseProperties = databaseProperties;
    }

    @Inject
    public void setUserDAO(UserDAO user){
        this.user = user;
    }
}
