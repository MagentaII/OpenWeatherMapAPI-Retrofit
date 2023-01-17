package com.example.weatherapiapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyAPIService {

    @GET("weather?q=Zocca&appid=d78b07546e8f32d14a6e92b7c1f9524d")
    Call<OpenWeather> getWeatherData();

    @GET("weather?appid=d78b07546e8f32d14a6e92b7c1f9524d")
    Call<OpenWeather> getCityName(@Query("q") String cityName);


}
