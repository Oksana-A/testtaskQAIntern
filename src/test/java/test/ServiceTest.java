package test;


import org.testng.annotations.Test;
import service.Service;
import utils.FileReader;

import java.util.HashMap;
import java.util.Map;


public class ServiceTest {
    private Service service = new Service(FileReader.getInstance().getSettings().get("baseUrl"));
    private String path = FileReader.getInstance().getSettings().get("path");
    private Map<String, Object> params;
    private int successStatusCode = 200;
    private int failureStatusCode = 404;


    @Test()
    public void nonexistentCompanyAndUser() {
        params = new HashMap<>();
        params.put("companyId", FileReader.getInstance().getTestData().get("nonexistentCompanyId"));
        params.put("someName", FileReader.getInstance().getTestData().get("nonExist"));
        service.getResponse(params, path).then().statusCode(failureStatusCode);
    }

    @Test()
    public void validCompanyAndUser() {
        params = new HashMap<>();
        params.put("companyId", FileReader.getInstance().getTestData().get("fistCompanyId"));
        params.put("someName", FileReader.getInstance().getTestData().get("fistCompanyUserName"));
        service.getResponse(params, path).then().statusCode(successStatusCode);
    }

    @Test()
    public void firstCompanyAndSecondCompanyUser() {
        params = new HashMap<>();
        params.put("companyId", FileReader.getInstance().getTestData().get("fistCompanyId"));
        params.put("someName", FileReader.getInstance().getTestData().get("secondCompanyUserName"));
        service.getResponse(params, path).then().statusCode(failureStatusCode);
    }

    @Test()
    public void firstCompanyAndNonexistentUser() {
        params = new HashMap<>();
        params.put("companyId", FileReader.getInstance().getTestData().get("fistCompanyId"));
        params.put("someName", FileReader.getInstance().getTestData().get("nonexistentUser"));
        service.getResponse(params, path).then().statusCode(failureStatusCode);
    }

    @Test()
    public void NonexistentCompanyAndFirstUser() {
        params = new HashMap<>();
        params.put("companyId", FileReader.getInstance().getTestData().get("nonexistentCompanyId"));
        params.put("someName", FileReader.getInstance().getTestData().get("fistCompanyUserName"));
        service.getResponse(params, path).then().statusCode(failureStatusCode);
    }
}
