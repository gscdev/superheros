package com.gsc.superheros.data.datasources;

import com.gsc.superheros.data.response.SuperherosResponse;
import com.gsc.superheros.data.ws.ApiService;

import java.io.IOException;
import java.util.List;

import static com.gsc.superheros.data.ws.RestClient.getClient;

public class ApiDataSource implements DataSource {

    @Override
    public List<SuperherosResponse.SuperheroResponse> getSuperheros() {
        List<SuperherosResponse.SuperheroResponse> response = null;
        try {
            response = getClient().create(ApiService.class).getSuperheros().execute().body().getSuperheroes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
