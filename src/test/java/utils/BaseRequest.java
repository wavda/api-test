package utils;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseRequest {
    public Response response;
    public RequestSpecification request;
    public RequestSpecification requestUpload;
    public JSONObject requestParam = new JSONObject();
    public String baseUrl = "http://pretest-qa.dcidev.id/api/v1";
    RestAssuredConfig timeoutConfig;
    RestAssuredConfig multiFormConfig;

    public BaseRequest() {
        timeoutConfig = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 30000));

        multiFormConfig = RestAssured.config().encoderConfig(encoderConfig()
                .encodeContentTypeAs("multipart/form-data", ContentType.TEXT));

        RestAssured.baseURI = baseUrl;
        request = RestAssured
                .given()
                .config(timeoutConfig)
                .config(multiFormConfig);

        requestUpload = RestAssured
                .given()
                .config(timeoutConfig)
                .config(multiFormConfig);
    }

    public JSONObject getRequest(String api) {
        response = request
                .header("Content-type", "application/json")
                .get(api)
                .then()
                .extract()
                .response();
        Allure.addAttachment("Response Body", response.getBody().asString());
        return new JSONObject(response.getBody().asString());
    }

    public JSONObject postRequest(String api) {
        response = request
                .header("Content-type", "application/json")
                .post(api)
                .then()
                .extract()
                .response();
        Allure.addAttachment("Response Body", response.getBody().asString());
        return new JSONObject(response.getBody().asString());
    }

    public JSONObject postUploadRequest(String api, File file) {
        response = requestUpload
                .multiPart("image", file, "multipart/form-data")
                .when()
                .post(api)
                .then()
                .extract()
                .response();

        Allure.addAttachment("Response Body", response.getBody().asString());
        return new JSONObject(response.getBody().asString());
    }

    public JSONObject deleteRequest(String api) {
        response = request
                .header("Content-type", "application/json")
                .delete(api)
                .then()
                .extract()
                .response();
        Allure.addAttachment("Response Body", response.getBody().asString());
        return new JSONObject(response.getBody().asString());
    }

    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
