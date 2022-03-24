package com.uppa.nationalite.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APi {
    @GET(".")
    Call<NationaliteResponse> getNationalite(@Query("name") String name);
}
