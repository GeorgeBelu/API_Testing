package org.example;

import org.example.entities.Pet;
import org.example.service.PetService;
import org.example.utils.PetUtils;
import org.testng.annotations.BeforeClass;

public class BaseTestClass
{
    public final PetService petService = PetService.getInstance();

    @BeforeClass
    protected Pet createPet()
    {
        return PetUtils.generateRandomPet();
    }

}
