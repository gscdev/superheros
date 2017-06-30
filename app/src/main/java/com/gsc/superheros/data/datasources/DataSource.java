package com.gsc.superheros.data.datasources;

import com.gsc.superheros.data.response.SuperherosResponse;

import java.util.List;

public interface DataSource {

    List<SuperherosResponse.SuperheroResponse> getSuperheros();
}
