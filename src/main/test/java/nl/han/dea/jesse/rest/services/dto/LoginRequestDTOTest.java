package nl.han.dea.jesse.rest.services.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestDTOTest {

    LoginRequestDTO sut = new LoginRequestDTO();

    @Test
    void getUserButUserIsNull() {
        // Act
        var actual = sut.getUser();
        // Assert
        Assertions.assertEquals(actual, null);
    }

    @Test
    void getUser(){
        // Arrange
        sut.setUser("jesse");
        // Act
        var actual = sut.getUser();
        // Assert
        Assertions.assertEquals(actual, "jesse");

    }


    // Here I need to mock
    @Test
    void setUser() {
        // Arrange

        // Act

        // Assert

    }


    @Test
    void getPasswordButPasswordIsNull(){
        // Act
        var actual = sut.getPassword();
        // Assert
        Assertions.assertEquals(actual, null);
    }
    @Test
    void getPassword() {
        sut.setPassword("123");
        // Act
        var actual = sut.getPassword();
        // Assert
        Assertions.assertEquals(actual, "123");
    }

    @Test
    void setPassword() {
        // Arrange

        // Act

        // Assert
    }
}