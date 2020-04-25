package com.harte.meteireannwidget.met;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;

public class ForecastService {

    @Inject
    public ForecastService(){}

    private MetApi getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://prodapi.metweb.ie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create an instance of the ApiService
        return retrofit.create(MetApi.class);
    }

    public ArrayList<MetForecast> getMetForecast(double longitude, double latutude) throws OutsideForecastException {
        this.validateCoOrdinates(longitude, latutude);

        // make a request by calling the corresponding method

        Call call = getApi().getDailyForecast(this.convertCoOrdToString(longitude), this.convertCoOrdToString(latutude));
        try {
            return (ArrayList<MetForecast>) call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CurrentObservation getShortForecast(County county)  {

            Call call = getApi().getCurrentObservance(county);
        try {
            return (CurrentObservation) call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private void validateCoOrdinates(double longitude, double latitude) throws OutsideForecastException {
        // Validates that user is not outside ireland
        if ((longitude > 11.7) ||
            (longitude < 3.8) ||
            (latitude > 56.2) ||
            (latitude < 50.5)) {
                throw new OutsideForecastException();
        }


    }

    private String convertCoOrdToString(double coOrd) {
        return String.format ("%.6f", coOrd);
    }

}
