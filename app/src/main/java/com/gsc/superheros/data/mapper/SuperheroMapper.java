package com.gsc.superheros.data.mapper;

import com.gsc.superheros.data.response.SuperherosResponse;
import com.gsc.superheros.model.Superhero;

public class SuperheroMapper extends BaseMapper<Superhero, SuperherosResponse.SuperheroResponse> {

    @Override
    Superhero transform(SuperherosResponse.SuperheroResponse superheroResponse) {
        return new Superhero(
                superheroResponse.getName(),
                superheroResponse.getPhoto(),
                superheroResponse.getRealName(),
                superheroResponse.getHeight(),
                superheroResponse.getPower(),
                superheroResponse.getAbilities(),
                superheroResponse.getGroups());
    }
}
