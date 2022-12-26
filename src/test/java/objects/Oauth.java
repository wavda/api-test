package objects;

import org.json.JSONObject;
import utils.BaseRequest;

public class Oauth extends BaseRequest {
    public JSONObject credentials(String accessToken) {
        return getRequest("/oauth/credentials?access_token=" + accessToken);
    }

    public JSONObject signIn(String phone, String password, String latlong, String device_token, String device_type) {
        requestParam.put("phone", phone);
        requestParam.put("password", password);
        requestParam.put("latlong", latlong);
        requestParam.put("device_token", device_token);
        requestParam.put("device_type", device_type);
        request.body(requestParam.toString());
        return postRequest("/oauth/sign_in");
    }

    public JSONObject revoke(String user_id, String otp_code) {
        requestParam.put("access_token", user_id);
        requestParam.put("confirm", otp_code);
        request.body(requestParam.toString());
        return postRequest("/oauth/revoke");
    }
}
