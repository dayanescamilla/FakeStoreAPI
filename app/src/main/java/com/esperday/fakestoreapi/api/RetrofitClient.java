package com.esperday.fakestoreapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "https://fakestoreapi.com/";
    public static Retrofit getClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static WebService getWS(){
        WebService webService = getClient().create(WebService.class);
        return webService;
    }
}
