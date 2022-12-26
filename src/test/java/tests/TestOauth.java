package tests;

import objects.Oauth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class TestOauth extends BaseTest {
    Oauth oauth = new Oauth();

    @Test
    @DisplayName("Get credentials")
    void credentials() {
        oauth.credentials(accessToken);
        oauth.verifyStatusCode(200);
    }

    @Test
    @DisplayName("Login user")
    void signIn() {
        oauth.signIn(phoneNumber, password, "1", "1", "1");
        oauth.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Logging out user and revoke token")
    void revoke() {
        oauth.revoke(userId, "1");
    }
}
