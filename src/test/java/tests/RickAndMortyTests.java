package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.RickAndMortySteps;

public class RickAndMortyTests {
    private RickAndMortySteps rickAndMortySteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        rickAndMortySteps = new RickAndMortySteps();
    }

    @Test(description = "Сравнение значений")
    void successGetMortyEpisodesTest() {
        Response response = rickAndMortySteps.getAllInformation(2);
        String speciesMorty = response.getBody().jsonPath().get("species");
        String locationMorty = response.getBody().jsonPath().get("location.name");
        String lastEpisodeMorty = response.getBody().jsonPath().get("episode[-1]");
        int lastEpisode = Integer.parseInt(lastEpisodeMorty.substring(40));

        String lastCharacterInEpisode = rickAndMortySteps.getLastCharacterEpisodes(lastEpisode);
        int lastCharacter = Integer.parseInt(lastCharacterInEpisode.substring(42));

        Response responseSecond = rickAndMortySteps.getAllInformation(lastCharacter);
        String speciesLastCharacter = responseSecond.getBody().jsonPath().get("species");
        String locationLastCharacter = responseSecond.getBody().jsonPath().get("location.name");

        Assert.assertEquals(speciesMorty, speciesLastCharacter, "Раса не совпадает");
        Assert.assertEquals(locationMorty, locationLastCharacter, "Локация не совпадает");
    }

}
