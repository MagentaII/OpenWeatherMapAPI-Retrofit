package com.example.weatherapiapp.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeather {

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
