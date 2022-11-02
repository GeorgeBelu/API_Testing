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

    public Response getPet(UriTemplate uri)
    {
        return super.getRequest(uri.getUri());
    }

    public Response getPetById(UriTemplate uri, int id)
    {
        return super.getRequest(uri.getUri(id));
    }

    public Response postPet(UriTemplate uri, Object body)
    {
        return super.postRequest(uri.getUri(), body);
    }

    public void deletePet(UriTemplate uri, int id)
    {
        super.deleteRequest(uri.getUri(id));
    }
}
