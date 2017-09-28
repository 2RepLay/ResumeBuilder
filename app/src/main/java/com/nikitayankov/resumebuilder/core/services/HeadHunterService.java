package com.nikitayankov.resumebuilder.core.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HeadHunterService {
    @GET("oauth/authorize?")
    Call<String> authCall(@Query("response_type")String response_type,
                          @Query("client_id")String client_id,
                          @Query("state")String state);

}
