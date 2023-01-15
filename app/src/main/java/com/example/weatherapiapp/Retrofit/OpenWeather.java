package com.example.weatherapiapp.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeather {

    @SerializedName("weather")
    private List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
