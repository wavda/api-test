package objects;

import org.json.JSONObject;
import utils.BaseRequest;

public class Profile extends BaseRequest {
    public Profile(String accessToken) {
        request.header("Authorization", accessToken);
    }

    public JSONObject career(String position, String companyName, String startingFrom, String endingIn) {
        requestParam.put("position", position);
        requestParam.put("company_name", companyName);
        requestParam.put("starting_from", startingFrom);
        requestParam.put("ending_in", endingIn);
        request.body(requestParam.toString());
        return postRequest("/profile/career");
    }

    public JSONObject education(String schoolName, String graduationTime) {
        requestParam.put("school_name", schoolName);
        requestParam.put("graduation_time", graduationTime);
        request.body(requestParam.toString());
        return postRequest("/profile/education");
    }

    public JSONObject profile(String name, String gender, String birthday, String hometown, String bio) {
        requestParam.put("name", name);
        requestParam.put("gender", gender);
        requestParam.put("birthday", birthday);
        requestParam.put("hometown", hometown);
        requestParam.put("bio", bio);
        request.body(requestParam.toString());
        return postRequest("/profile");
    }

    public JSONObject me() {
        return getRequest("/profile/me");
    }
}
