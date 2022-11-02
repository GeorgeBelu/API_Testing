package org.example.testpet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.BaseTestClass;
import org.example.entities.Pet;
import org.testng.annotations.Test;

import static org.example.service.uritemplate.PetServiceUri.PETS;
import static org.example.service.uritemplate.PetServiceUri.PETS_BY_ID;
import static org.hamcrest.Matchers.equalTo;

public class PetTest extends BaseTestClass
{
    public Pet expectedPet = createPet();

    @Test
    public void createPetTest()
    {
        Response response = petService.postPet(PETS, expectedPet);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(expectedPet.getId()))
                .body("name", equalTo(expectedPet.getName()))
                .body("status", equalTo(expectedPet.getStatus()));
    }

    @Test(dependsOnMethods = "createPetTest")
    public void getPetByIdTest()
    {
        Response response = petService.getPetById(PETS_BY_ID, expectedPet.getId());
        response.then()
                .assertThat()
                .statusCode(200)
                .body("id",equalTo(expectedPet.getId()))
                .contentType(ContentType.JSON);
    }

    @Test(dependsOnMethods = "getPetByIdTest")
    public void deletePetTest()
    {
        Response response = petService.deletePetById(PETS_BY_ID, expectedPet.getId());
        response.then()
                .assertThat()
                .statusCode(200)
                .body("type", equalTo("unknown"))
                .body("message", equalTo(String.valueOf(expectedPet.getId())));
    }
}