package tests;

import objects.Uploads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class TestUploads extends BaseTest {
    Uploads uploads;
    String pictureFilePath = "src/test/resources/images/cat.png";

    @BeforeEach
    void setUp() {
        initiateData();
        uploads = new Uploads(accessToken);
    }

    @Test
    @DisplayName("Set cover picture")
    void setCoverPicture() {
        uploads.setCoverPicture(pictureFilePath);
        uploads.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Set default picture")
    void setDefaultPicture() {
        String id = uploads.getPictureId(pictureFilePath);
        uploads.setDefaultPicture(id);
        uploads.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Delete profile picture")
    void deleteProfilePicture() {
        String id = uploads.getPictureId(pictureFilePath);
        uploads.deleteProfilePicture(id);
    }

    @Test
    @DisplayName("Upload profile picture")
    void uploadProfilePicture() {
        uploads.uploadProfilePicture(pictureFilePath);
        uploads.verifyStatusCode(201);
    }
}
