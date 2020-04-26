package com.harte.meteireannwidget.met;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import javax.inject.Inject;
import java.util.ArrayList;

public class MetService {

    MetApi api;

    @Inject
    public MetService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://prodapi.metweb.ie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
                .build();

        // create an instance of the ApiService
        this.api = retrofit.create(MetApi.class);
    }

    private MetApi getApi() {
        return this.api;
    }

    public Observable<ArrayList<MetForecast>> getMetForecast(double longitude, double latutude) throws OutsideForecastException {
        this.validateCoOrdinates(longitude, latutude);

        // make a request by calling the corresponding method

        return getApi().getDailyForecast(this.convertCoOrdToString(longitude), this.convertCoOrdToString(latutude));
    }

    public Observable<CurrentObservation> getShortForecast(County county)  {
        return getApi().getCurrentObservance(county);
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
