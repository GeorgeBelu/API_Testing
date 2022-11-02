package org.example.utils;

import org.example.entities.Category;
import org.example.entities.Pet;
import org.example.entities.Tag;

import java.util.List;
import java.util.Random;

public class PetUtils
{

    static Random random = new Random();
    public static Pet generateRandomPet()
    {
        return new Pet()
                .setId(random.nextInt(Integer.MAX_VALUE))
                .setCategory(generateCategory())
                .setName("Placeholder" + random.nextInt(Integer.MAX_VALUE))
                .setPhotoUrls(List.of("photoUrl"))
                .setTags(List.of(generateTag()))
                .setStatus("available");
    }

    public static Tag generateTag()
    {
        return new Tag()
                .setId(random.nextInt(Integer.MAX_VALUE))
                .setName("Tag" + random.nextInt(Integer.MAX_VALUE));
    }

    public static Category generateCategory()
    {
        return new Category()
                .setId(random.nextInt(Integer.MAX_VALUE))
                .setName("Category" + random.nextInt(Integer.MAX_VALUE));
    }

}