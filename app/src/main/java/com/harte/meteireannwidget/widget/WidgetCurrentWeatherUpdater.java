package com.harte.meteireannwidget.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.harte.meteireannwidget.ForecastActivity;
import com.harte.meteireannwidget.location.CountyService;
import com.harte.meteireannwidget.met.County;
import com.harte.meteireannwidget.weather.CurrentWeather;

import java.util.concurrent.TimeUnit;

public class WidgetCurrentWeatherUpdater extends Worker {
    private static final String TAG = "WidgetCurrWeatherUpdate";
    CountyService countyService;
    ForecastService forecastService;

    public WidgetCurrentWeatherUpdater(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
        this.countyService = new CountyService(context);
        this.forecastService = ForecastActivity.getForecastComponent().getForecastService();

    }
    @NonNull
    @Override
    public Result doWork() {
        Log.i(TAG, "Weather update job starting");
        County currentCounty = countyService.determineCurrentCounty();
        if (currentCounty != null) {
            CurrentWeather weather = this.forecastService.getCurrentWeather(currentCounty).toBlocking().first();
            if (weather == null) {
                return Result.failure();
            }
            updateAllWidgets(weather);
        }
        return Result.success();
    }

    public static Constraints getScheduledJobConstraints() {
        return new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setTriggerContentMaxDelay(1, TimeUnit.MINUTES)
                .build();
    }

    public void updateAllWidgets(CurrentWeather weather) {
        Context context = getApplicationContext();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] ids = appWidgetManager.getAppWidgetIds(new ComponentName("com.harte.meteireannwidget", WeatherWidget.class.getName()));
        Log.i(TAG, "Applying update");
        for (int id: ids) {
            WeatherWidget.updateAppWidget(context, appWidgetManager, id, weather);
            Log.i(TAG, "update applied to widget " + String.valueOf(id));
        }
    }
}
