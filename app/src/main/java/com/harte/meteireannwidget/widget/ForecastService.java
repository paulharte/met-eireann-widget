package com.harte.meteireannwidget.widget;

import android.util.Log;

import com.harte.meteireannwidget.imageFetch.ImageFetcher;
import com.harte.meteireannwidget.met.County;
import com.harte.meteireannwidget.met.CurrentObservation;
import com.harte.meteireannwidget.met.MetService;
import rx.Observable;

import javax.inject.Inject;
import java.math.BigDecimal;

public class ForecastService {
    MetService metService;
    ImageFetcher imgFetch;

    @Inject
    public ForecastService(MetService metService, ImageFetcher imgFetch) {
        this.metService = metService;
        this.imgFetch = imgFetch;
    }


    public Observable<CurrentWeather> getCurrentWeather(County county) {
        return this.metService.getShortForecast(county).map(obs -> this.mapMetObservanceToWeather(obs));
    }

    private CurrentWeather mapMetObservanceToWeather(CurrentObservation obs) {
        Log.i("ForecastService", obs.toString());
        Log.i("ForecastService", obs.getSymbol());
        Log.i("ForecastServiceDesc", obs.getWeatherDescription());
        Log.i("ForecastServiceTemp", obs.getTemperature());
        int weatherSymbol = imgFetch.fetchWeatherSymbol(obs.getSymbol());

        return new CurrentWeather(weatherSymbol,
                obs.getWeatherDescription(),
                this.getTempFromObservance(obs),
                this.getWindFromObservance(obs));
    }


    private Wind getWindFromObservance(CurrentObservation obs) {
        //TODO: catch decimal conversion exception here
        BigDecimal speed = new BigDecimal(obs.getWindSpeed());
        BigDecimal directionDegrees = new BigDecimal(obs.getWindDirection());
        return new Wind(speed,directionDegrees  );
    }

    private Temperature getTempFromObservance(CurrentObservation obs) {
        //TODO: catch decimal conversion exception here
        return new Temperature(new BigDecimal(obs.getTemperature()));
    }
}
