package utils;

import objects.Register;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    public String userId;
    public String accessToken;
    public String phoneNumber;
    public String password = "Test@123";
    public Register register;

    @BeforeEach
    void setUp() {
        initiateData();
    }

    @AfterEach()
    void removeAccount() {
        register.remove(phoneNumber);
        register.verifyStatusCode(201);
    }

    protected void initiateData() {
        register = new Register();
        phoneNumber = new DataGenerator().generateRandomPhoneNumber(9);
        userId = register.getUserId(phoneNumber);
        accessToken = register.getAccessToken(userId);
    }
}
