package tests;

import objects.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class TestMessage extends BaseTest {
    Message message;

    @BeforeEach
    void setUp() {
        initiateData();
        message = new Message(accessToken);
    }

    @Test
    @DisplayName("Get message")
    void getMessage() {
        message.getMessage(userId);
        message.verifyStatusCode(200);
    }

    @Test
    @DisplayName("Send message")
    void sendMessage() {
        message.sendMessage(userId, "Hello!!");
        message.verifyStatusCode(201);
    }
}
