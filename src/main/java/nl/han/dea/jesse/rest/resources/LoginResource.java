package nl.han.dea.jesse.rest.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.jesse.rest.datasource.UserDAO;
import nl.han.dea.jesse.rest.datasource.util.DatabaseProperties;
import nl.han.dea.jesse.rest.services.LoginService;
import nl.han.dea.jesse.rest.services.dto.LoginRequestDTO;
import nl.han.dea.jesse.rest.services.dto.LoginResponseDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static jakarta.ws.rs.core.Response.ok;

@Path("/login")
public class LoginResource {

    private UserDAO user;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequestDTO){

        if(loginRequestDTO == null){
            return Response.status(401).build();
        } else{
            var loginResponseDTO = user.login(loginRequestDTO.getUser());

            var response = ok(loginResponseDTO).build();

            return response;
        }
    }

    @Inject
    public void setUserDAO(UserDAO userDAO){
        this.user = userDAO;
    }

}
