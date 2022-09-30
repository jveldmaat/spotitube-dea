package nl.han.dea.jesse.rest.services;

public class LoginService {

    public String login(String username, String password){
        if(username.equals("jesse") && password.equals("123")){
            // return the username for the user
            return "Jesse Veldmaat";
        } else{
            return "";
        }
    }
}
