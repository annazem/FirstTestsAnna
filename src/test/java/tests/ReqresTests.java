package tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.ReqresSteps;

public class ReqresTests {
    private ReqresSteps reqresSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        reqresSteps = new ReqresSteps();
    }

    @Test(description = "Создание клиента")
    void successCreateClientTest() {
        String clientCreateRequestBody = reqresSteps.getReqresRequestBody("client.json");
        String clientCreateResponseBody = reqresSteps.postClient(clientCreateRequestBody);

        String clientUpdateRequestBody = reqresSteps.getReqresRequestBody("clientupdate.json");
        String clientUpdateResponseBody = reqresSteps.postClient(clientUpdateRequestBody);

        String expectedCreateClientName = new JSONObject(clientCreateRequestBody).get("name").toString();
        String actualCreateClientName = new JSONObject(clientCreateResponseBody).get("name").toString();

        String expectedUpdateClientName = new JSONObject(clientUpdateRequestBody).get("name").toString();
        String expectedUpdateClientJob = new JSONObject(clientUpdateRequestBody).get("job").toString();
        String actualUpdateClientName = new JSONObject(clientUpdateResponseBody).get("name").toString();
        String actualUpdateClientJob = new JSONObject(clientUpdateResponseBody).get("job").toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCreateClientName, expectedCreateClientName, "Имя сохранилось неверно");
        softAssert.assertEquals(actualUpdateClientName, expectedUpdateClientName, "Имя обновилось неверно");
        softAssert.assertEquals(actualUpdateClientJob, expectedUpdateClientJob, "Место работы обновилось неверно");
        softAssert.assertAll();
    }
}
