package api.tests;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import api.steps.ReqresSteps;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Api тесты")
@Feature("Reqres тесты")
@Story("POST and PUT client")
public class ReqresTests {
    private ReqresSteps reqresSteps;

    @BeforeClass(description = "Добавляем фильтр Allure для RestAssured", alwaysRun = true)
    void addFilters() {
        RestAssured.filters(new AllureRestAssured());
    }

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        reqresSteps = new ReqresSteps();
    }

    @Issue("SPC-2122")
    @TmsLink("231493")
    @Test(description = "Создание и обновление клиента")
    void successCreateClientTest() {
        //Создание клиента
        String clientCreateRequestBody = reqresSteps.getReqresRequestBody("client.json");
        String clientCreateResponseBody = reqresSteps.postClient(clientCreateRequestBody);

        String expectedCreateClientName = new JSONObject(clientCreateRequestBody).get("name").toString();
        String actualCreateClientName = new JSONObject(clientCreateResponseBody).get("name").toString();
        String actualCreateClientID = new JSONObject(clientCreateResponseBody).get("id").toString();

        //Обновление клиента
        String clientUpdateRequestBody = reqresSteps.getReqresRequestBody("clientupdate.json");
        String clientUpdateResponseBody = reqresSteps.putClient(clientUpdateRequestBody, actualCreateClientID);

        String expectedUpdateClientName = new JSONObject(clientUpdateRequestBody).get("name").toString();
        String expectedUpdateClientJob = new JSONObject(clientUpdateRequestBody).get("job").toString();
        String actualUpdateClientName = new JSONObject(clientUpdateResponseBody).get("name").toString();
        String actualUpdateClientJob = new JSONObject(clientUpdateResponseBody).get("job").toString();

        //Проверки на корректность изменения
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualCreateClientName, expectedCreateClientName, "Имя сохранилось неверно");
        softAssert.assertEquals(actualUpdateClientName, expectedUpdateClientName, "Имя обновилось неверно");
        softAssert.assertEquals(actualUpdateClientJob, expectedUpdateClientJob, "Место работы обновилось неверно");
        softAssert.assertAll();
    }
}
