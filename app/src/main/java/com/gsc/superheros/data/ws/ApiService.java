package com.gsc.superheros.data.ws;

import com.gsc.superheros.data.response.SuperherosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("bins/bvyob")
    Call<SuperherosResponse> getSuperheros();
}
