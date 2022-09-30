package nl.han.dea.jesse.rest.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void login() {
        // Arrange
        var sut = new LoginService();
        // Act
        var actual = sut.login("jesse", "123");

        // Assert
        Assertions.assertEquals("Jesse Veldmaat", actual);
    }

    @Test
    void loginWrongInformation(){
        // Arrange
        var sut = new LoginService();
        // Act
        var actual = sut.login("Jes","12");
        // Assert
        Assertions.assertEquals("",actual);
    }
}