package com.harte.meteireannwidget.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.harte.meteireannwidget.ForecastActivity;
import com.harte.meteireannwidget.ForecastComponent;
import com.harte.meteireannwidget.R;
import com.harte.meteireannwidget.met.*;
import com.harte.meteireannwidget.permissions.RequestPermissions;
import com.harte.meteireannwidget.weather.CurrentWeather;


/**
 * Implementation of App Widget functionality.
 */
public class WeatherWidget extends AppWidgetProvider {

    private static final String TAG = "TodaysWeatherWidget";
    private ForecastComponent forecastComponent;
    private County currentCounty;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId, CurrentWeather weather) {

        Log.i(TAG, "updating weather widget");

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.todays_weather_widget);

        views.setImageViewResource(R.id.today_img, weather.getSymbol());
        views.setTextViewText(R.id.appwidget_text, weather.getDescription());
        views.setTextViewText(R.id.wind_text, weather.getWind().getWindSpeedKmStr(true));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
        Log.i(TAG, "successfully updated weather widget");
        Log.i(TAG, weather.toString());
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        // ...then create a OneTimeWorkRequest that uses those constraints
        OneTimeWorkRequest updateWork =
                new OneTimeWorkRequest.Builder(WidgetCurrentWeatherUpdater.class)
                        //.setConstraints(WidgetCurrentWeatherUpdater.getScheduledJobConstraints())
                        .build();
        WorkManager.getInstance(context).enqueue(updateWork);
        Log.i(TAG, "Weather update job enqueued");

    }


    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            //DO DELETE ACTIONS HERE
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        Log.i(TAG, "met eireann widget enabled");

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

