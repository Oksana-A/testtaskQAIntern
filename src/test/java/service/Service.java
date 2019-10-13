package service;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Service {
    private String baseUrl;

    public Service(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response getResponse(Map<String, Object> params, String path) {
        return given()
                .baseUri(baseUrl)
                .pathParams(params)
                .when()
                .get(path);
    }

}
