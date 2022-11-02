package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class PetService extends CommonService
{

    private static PetService instance;

    public static PetService getInstance()
    {
        if (instance == null)
        {
            instance = new PetService();
        }
        return instance;
    }

    public Response getPetById(UriTemplate uri, int id)
    {
        return super.getRequest(uri.getUri(id));
    }

    public Response postPet(UriTemplate uri, Object body)
    {
        return super.postRequest(uri.getUri(), body);
    }

    public Response deletePetById(UriTemplate uri, int id)
    {
        return super.deleteRequest(uri.getUri(id));

    }
}
