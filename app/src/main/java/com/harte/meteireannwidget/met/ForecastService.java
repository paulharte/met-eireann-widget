package com.harte.meteireannwidget.met;


import dagger.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

@Component
public class ForecastService {


    public ArrayList<MetForecast> getMetForecast(double longitude, double latutude) throws OutsideForecastException {
        this.validateCoOrdinates(longitude, latutude);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://prodapi.metweb.ie/")
        .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create an instance of the ApiService
        MetApi apiService = retrofit.create(MetApi.class);
        // make a request by calling the corresponding method
        return apiService.getDailyForecast(this.convertCoOrdToString(longitude), this.convertCoOrdToString(latutude));


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


    //https://prodapi.metweb.ie/weather/daily/53.2747/-6.2253/7

    //        [{"day":"Evening","shortDayName":"Sun","shortDate":"29th","htmlDate":"29-03-2020","time":"19:00","date":"2020-03-29","weather":"sun","weatherNumber":"01d","weatherDescription":"Sun \/ Clear sky","wind-speed":21,"windDescription":"North-Easterly","rainfall":"0.0","wind-direction":"49.5","temperature":5,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"52.9","pressure":"1046.4","localTime":"1800","appTime":"Sun 29th March","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":1},
    //{"day":"Tonight","shortDayName":"Mon","shortDate":"30th","htmlDate":"30-03-2020","time":"01:00","date":"2020-03-30","weather":"partlycloud","weatherNumber":"03n","weatherDescription":"Partly Cloudy","wind-speed":14,"windDescription":"North-Westerly","rainfall":"0.0","wind-direction":"307.3","temperature":1,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"77.3","pressure":"1045.0","localTime":"0000","appTime":"Mon 30th March","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":2},{"day":"Tomorrow","shortDayName":"Mon","shortDate":"30th","htmlDate":"30-03-2020","time":"13:00","date":"2020-03-30","weather":"cloud","weatherNumber":"04d","weatherDescription":"Cloudy","wind-speed":20,"windDescription":"North-Easterly","rainfall":"0.0","wind-direction":"41.1","temperature":7,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"73.9","pressure":"1040.4","localTime":"1200","appTime":"Mon 30th March","canonicalWindDirection":"NE","dayIndex":1,"dayNumber":2},{"day":"Tuesday","shortDayName":"Tue","shortDate":"31st","htmlDate":"31-03-2020","time":"13:00","date":"2020-03-31","weather":"cloud","weatherNumber":"04d","weatherDescription":"Cloudy","wind-speed":15,"windDescription":"North-Easterly","rainfall":"0.0","wind-direction":"42.8","temperature":7,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"75.8","pressure":"1036.7","localTime":"1200","appTime":"Tue 31st March","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":3},{"day":"Wednesday","shortDayName":"Wed","shortDate":"1st","htmlDate":"01-04-2020","time":"13:00","date":"2020-04-01","weather":"cloud","weatherNumber":"04d","weatherDescription":"Cloudy","wind-speed":15,"windDescription":"North-Westerly","rainfall":"0.0","wind-direction":"306.3","temperature":7,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"70.3","pressure":"1026.3","localTime":"1200","appTime":"Wed 1st April","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":4},{"day":"Thursday","shortDayName":"Thu","shortDate":"2nd","htmlDate":"02-04-2020","time":"13:00","date":"2020-04-02","weather":"partlycloud","weatherNumber":"03d","weatherDescription":"Partly Cloudy","wind-speed":30,"windDescription":"Westerly","rainfall":"0.0","wind-direction":"280.0","temperature":10,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"59.0","pressure":"1015.3","localTime":"1200","appTime":"Thu 2nd April","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":5},{"day":"Friday","shortDayName":"Fri","shortDate":"3rd","htmlDate":"03-04-2020","time":"13:00","date":"2020-04-03","weather":"lightrainsun","weatherNumber":"05d","weatherDescription":"Rain showers","wind-speed":19,"windDescription":"Westerly","rainfall":"0.6","wind-direction":"257.0","temperature":9,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"66.8","pressure":"1012.6","localTime":"1200","appTime":"Fri 3rd April","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":6},{"day":"Saturday","shortDayName":"Sat","shortDate":"4th","htmlDate":"04-04-2020","time":"13:00","date":"2020-04-04","weather":"cloud","weatherNumber":"04d","weatherDescription":"Cloudy","wind-speed":28,"windDescription":"Southerly","rainfall":"0.0","wind-direction":"186.7","temperature":10,"temperature-class":"yellow","warnings":{"level":"Green"},"humidity":"63.8","pressure":"1006.9","localTime":"1200","appTime":"Sat 4th April","canonicalWindDirection":"NE","dayIndex":0,"dayNumber":7}]
}
