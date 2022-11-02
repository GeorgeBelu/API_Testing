package org.example.testpet;

import io.restassured.response.Response;
import org.example.BaseTestClass;
import org.example.entities.Pet;
import org.testng.annotations.Test;

import static org.example.service.uritemplate.PetServiceUri.PETS;
import static org.hamcrest.Matchers.equalTo;

public class PetTest extends BaseTestClass
{
    public Pet expectedPet = createPet();

    @Test
    public void createPetTest()
    {
        Response response = petService.postPet(PETS, expectedPet);
        response.then().assertThat()
                .statusCode(200).
                body("id", equalTo(expectedPet.getId())).
                body("name", equalTo(expectedPet.getName())).
                body("status", equalTo(expectedPet.getStatus()));
    }
}