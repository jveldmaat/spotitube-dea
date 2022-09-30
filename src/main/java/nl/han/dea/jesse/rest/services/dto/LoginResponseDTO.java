package nl.han.dea.jesse.rest.services.dto;

public class LoginResponseDTO {

    private String user;

    private String token;

    public LoginResponseDTO(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getUser() {
        return user;

    }
}