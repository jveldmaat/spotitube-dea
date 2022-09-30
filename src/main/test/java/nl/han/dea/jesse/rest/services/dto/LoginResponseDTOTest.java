package nl.han.dea.jesse.rest.services.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginResponseDTOTest {

private LoginResponseDTO testResource;
    @BeforeEach
    void setup() {
        //Arrange
        testResource = new LoginResponseDTO("jesse", "1234-1234");
    }

    @Test
    void getToken() {
        // Act
        var actual = testResource.getToken();
        // Assert
        Assertions.assertEquals(actual,"1234-1234");
    }

    @Test
    void getUser() {
        // Act
        var actual = testResource.getUser();
        // Assert
        Assertions.assertEquals(actual,"jesse");
    }
}