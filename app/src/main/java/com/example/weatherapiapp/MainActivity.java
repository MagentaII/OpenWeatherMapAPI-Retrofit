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

    private final String APIKEY = "d78b07546e8f32d14a6e92b7c1f9524d";
    private Button btnGetWeatherByCityName, btnGetWeatherByCityID, btnGetCityID;
    private EditText etDataInput;
    private RecyclerView recyclerViewWeather;
    MyAPIService myAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();

        btnGetCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });

        btnGetWeatherByCityID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnGetWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

}