package com.example.weatherapiapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Singleton
public class RetrofitManager {

    private static final RetrofitManager mInstance = new RetrofitManager();

    private final MyAPIService myAPIService;

    private RetrofitManager(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPIService = retrofit.create(MyAPIService.class);
    }

    public static RetrofitManager getInstance(){
        return mInstance;
    }

    public MyAPIService getAPI(){
        return myAPIService;
    }

}
