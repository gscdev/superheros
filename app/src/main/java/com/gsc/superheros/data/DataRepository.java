package com.gsc.superheros.data;

import com.gsc.superheros.data.datasources.ApiDataSource;
import com.gsc.superheros.data.datasources.DataSource;
import com.gsc.superheros.data.response.SuperherosResponse;
import com.gsc.superheros.data.mapper.SuperheroMapper;
import com.gsc.superheros.model.Superhero;

import java.util.List;

public class DataRepository {

    private final DataSource dataSource;
    private final SuperheroMapper superheroMapper;

    public DataRepository() {
        dataSource = new ApiDataSource();
        superheroMapper = new SuperheroMapper();
    }

    public List<Superhero> getSuperheros() {
        List<Superhero> superheros = null;

        List<SuperherosResponse.SuperheroResponse> superherosResponse = dataSource.getSuperheros();

        if (superherosResponse != null) {
            superheros = superheroMapper.transform(superherosResponse);
        }

        return superheros;
    }
}
