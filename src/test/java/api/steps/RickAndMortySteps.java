package api.steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    private final RequestSpecification rickSpecification = new RequestSpecBuilder().setBaseUri("https://rickandmortyapi.com/api").build();

    @Step("Выполняем запрос на получение информации по ID персонажа")
    public Response getAllInformation(int characterId) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/character/" + characterId)
                .then()
                .extract()
                .response();
        return response;
    }

    @Step("Выполняем запрос на получение информации по ID эпизода")
    public String getLastCharacterEpisodes(int episodeId) {
        Response response = given()
                .spec(rickSpecification)
                .when()
                .get("/episode/" + episodeId)
                .then()
                .extract()
                .response();
        String lastCharacters = response.getBody().jsonPath().get("characters[-1]");
        return lastCharacters;
    }
}