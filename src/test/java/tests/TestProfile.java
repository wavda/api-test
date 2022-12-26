package tests;

import objects.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class TestProfile extends BaseTest {
    Profile profile;

    @BeforeEach
    void setUp() {
        initiateData();
        profile = new Profile(accessToken);
    }

    @Test
    @DisplayName("Update career user")
    void career() {
        profile.career("Tester", "TestComp", "2022-01-01", "2022-12-12");
        profile.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Update education user")
    void education() {
        profile.education("Testo", "2022-01-01");
        profile.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Update profile user")
    void profile() {
        profile.profile("Test User", "1", "2000-01-01", "Indonesia", "Potato");
        profile.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Get current user")
    void getCurrentUser() {
        profile.me();
        profile.verifyStatusCode(200);
    }
}
