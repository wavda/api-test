package objects;

import org.json.JSONObject;
import utils.BaseRequest;

public class Register extends BaseRequest {
    public JSONObject remove(String phone) {
        requestParam.put("phone", phone);
        request.body(requestParam.toString());
        return postRequest("/register/remove");
    }

    public JSONObject otpRequest(String phone) {
        requestParam.put("phone", phone);
        request.body(requestParam.toString());
        return postRequest("/register/otp/request");
    }

    public JSONObject otpMatch(String userId, String otp_code) {
        requestParam.put("user_id", userId);
        requestParam.put("otp_code", otp_code);
        request.body(requestParam.toString());
        return postRequest("/register/otp/match");
    }

    public JSONObject register(String phone, String password, String country, String latlong, String device_token, String device_type) {
        requestParam.put("phone", phone);
        requestParam.put("password", password);
        requestParam.put("country", country);
        requestParam.put("latlong", latlong);
        requestParam.put("device_token", device_token);
        requestParam.put("device_type", device_type);
        request.body(requestParam.toString());
        return postRequest("/register");
    }

    public String getUserId(String phoneNumber) {
        JSONObject body = register(phoneNumber, "Test@123", "Indonesia", "123", "1", "0");
        verifyStatusCode(201);
        JSONObject data = (JSONObject) body.get("data");
        JSONObject user = (JSONObject) data.get("user");
        return user.get("id").toString();
    }

    public String getAccessToken(String user_id) {
        JSONObject body = otpMatch(user_id, "1");
        JSONObject data = (JSONObject) body.get("data");
        JSONObject user = (JSONObject) data.get("user");
        return user.get("access_token").toString();
    }
}
