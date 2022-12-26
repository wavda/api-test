package objects;

import org.json.JSONObject;
import utils.BaseRequest;

import java.io.File;

public class Uploads extends BaseRequest {
    public Uploads(String accessToken) {
        request.header("Authorization", accessToken);
        requestUpload.header("Authorization", accessToken);
    }

    public JSONObject setCoverPicture(String filePath) {
        File file = new File(filePath);
        return postUploadRequest("/uploads/cover", file);
    }

    public JSONObject setDefaultPicture(String id) {
        requestParam.put("id", id);
        request.body(requestParam.toString());
        return postRequest("/uploads/profile/default");
    }

    public JSONObject deleteProfilePicture(String id) {
        requestParam.put("id", id);
        request.body(requestParam.toString());
        return deleteRequest("/uploads/profile");
    }

    public JSONObject uploadProfilePicture(String filePath) {
        File file = new File(filePath);
        return postUploadRequest("/uploads/profile", file);
    }

    public String getPictureId(String filePath) {
        JSONObject body = uploadProfilePicture(filePath);
        JSONObject data = (JSONObject) body.get("data");
        JSONObject userPicture = (JSONObject) data.get("user_picture");
        return userPicture.get("id").toString();
    }
}
