package com.example.jal;

import java.util.List;
import retrofit2.Call;

import retrofit2.http.GET;

public interface JsonPlcaeHolderApi {

    @GET("jpa/dailydelivery")
    Call<List<Dailydelivery>> getDailydelivery();
}


