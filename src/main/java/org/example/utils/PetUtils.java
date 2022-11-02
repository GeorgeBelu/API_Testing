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
                .setStatus(String.valueOf(PetStatusEnum.petStatus()));
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

    public enum PetStatusEnum
    {
        available, pending, sold;
        private static final Random status = new Random();
        public static PetStatusEnum petStatus()
        {
            PetStatusEnum[] statuses = values();
            return statuses[status.nextInt(statuses.length)];
        }
    }
}