package objects;

import org.json.JSONObject;
import utils.BaseRequest;

public class Message extends BaseRequest {
    public Message(String accessToken) {
        request.header("Authorization", accessToken);
    }

    public JSONObject getMessage(String user_id) {
        return getRequest("/message/" + user_id);
    }

    public JSONObject sendMessage(String user_id, String message) {
        requestParam.put("user_id", user_id);
        requestParam.put("message", message);
        request.body(requestParam.toString());
        return postRequest("/message/send");
    }
}
