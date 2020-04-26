package com.harte.meteireannwidget.met;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.ArrayList;

public interface MetApi {

    @GET("weather/daily/{longitude}/{latitude}")
    Observable<ArrayList<MetForecast>> getDailyForecast(@Path("longitude") String longitude,
                                                        @Path("longitude") String latitude);

    @GET("weather/short/{county}")
    Observable<CurrentObservation> getCurrentObservance(@Path("county") County county);
}
