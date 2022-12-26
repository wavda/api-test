package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

public class TestRegister extends BaseTest {
    @Test
    @DisplayName("Register matching OTP code")
    void registerMatchingOtpCode() {
        register.otpMatch(userId, "123");
        register.verifyStatusCode(201);
    }

    @Test
    @DisplayName("Register Resend OTP")
    void resendOtp() {
        register.otpRequest(phoneNumber);
        register.verifyStatusCode(201);
    }
}
