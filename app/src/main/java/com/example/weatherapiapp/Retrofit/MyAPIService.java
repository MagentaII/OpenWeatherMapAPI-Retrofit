package com.example.weatherapiapp.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyAPIService {

    @GET("weather?lat=44.34&lon=10.99&appid=d78b07546e8f32d14a6e92b7c1f9524d")
    Call<OpenWeather> getWeatherData();


}
