package tests;

import objects.Notification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestNotification {
    Notification notification = new Notification();

    @Test
    @DisplayName("Get message")
    void checkAppVersion() {
        notification.checkAppVersion("1", "1");
    }
}
