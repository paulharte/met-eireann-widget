package com.harte.meteireannwidget.met;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface MetApi {

    @GET("weather/daily/{longitude}/{latitude}")
    ArrayList<MetForecast> getDailyForecast(@Path("longitude") String longitude,
                                         @Path("longitude") String latitude);
}
