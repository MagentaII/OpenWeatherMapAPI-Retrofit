package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapiapp.Retrofit.MyAPIService;
import com.example.weatherapiapp.Retrofit.OpenWeather;
import com.example.weatherapiapp.Retrofit.RetrofitManager;
import com.example.weatherapiapp.Retrofit.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnGetWeatherByCityName, btnGetWeatherByCityID, btnGetCityID;
    private EditText etDataInput;
    private RecyclerView recyclerViewWeather;
    MyAPIService myAPIService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        String cityName = etDataInput.getText().toString();

        btnGetCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCityID(cityName);
            }
        });

        btnGetWeatherByCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        btnGetWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeatherByCityName(cityName);
            }
        });

    }

    private void initializeVariables(){
        btnGetWeatherByCityName = findViewById(R.id.btn_getWeatherByCityName);
        btnGetWeatherByCityID = findViewById(R.id.btn_getWeatherByCityID);
        btnGetCityID = findViewById(R.id.btn_getCityID);
        etDataInput = findViewById(R.id.et_dataInput);
        recyclerViewWeather = findViewById(R.id.recyclerView_weatherReports);
    }

    private void getWeather(){
        myAPIService = RetrofitManager.getInstance().getAPI();

        Call<OpenWeather> call = myAPIService.getWeatherData();

        call.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                OpenWeather openWeather = response.body();
                List<Weather> des = openWeather.getWeather();
                for(Weather data : des){
                    Toast.makeText(MainActivity.this, data.getMain(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCityID(String cityName){
        myAPIService = RetrofitManager.getInstance().getAPI();

        Call<OpenWeather> call = myAPIService.getCityName(cityName);
        call.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                int id = response.body().getId();
                Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWeatherByCityName(String cityName){
        myAPIService = RetrofitManager.getInstance().getAPI();

        Call<OpenWeather> call = myAPIService.getCityName(cityName);
        call.enqueue(new Callback<OpenWeather>() {
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                List<Weather> weatherList = response.body().getWeather();

                for(Weather data : weatherList){
                    Toast.makeText(MainActivity.this, data.getMain(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {

            }
        });
    }

}