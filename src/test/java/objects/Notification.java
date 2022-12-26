package objects;

import org.json.JSONObject;
import utils.BaseRequest;

public class Notification extends BaseRequest {
    public JSONObject checkAppVersion(String grub_id, String token) {
        return getRequest("/notification/" + grub_id + "/" + token);
    }
}
