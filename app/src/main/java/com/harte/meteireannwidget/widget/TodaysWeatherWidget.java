package com.harte.meteireannwidget.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;
import com.harte.meteireannwidget.DaggerForecastComponent;
import com.harte.meteireannwidget.ForecastComponent;
import com.harte.meteireannwidget.R;
import com.harte.meteireannwidget.met.*;

import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Implementation of App Widget functionality.
 */
public class TodaysWeatherWidget extends AppWidgetProvider {

    private static final String TAG = "MyActivity";

    ForecastComponent forecastComponent;

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
        this.forecastComponent = DaggerForecastComponent.create();

        ForecastService forc = this.forecastComponent.getForecastService();
        forc.getCurrentWeather(County.Dublin)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<CurrentWeather>() {
                               @Override
                               public void onCompleted() {
                                   Log.d(TAG, "[onCompleted] ");
                               }

                               @Override
                               public void onError(Throwable t) {
                                   Log.d(TAG, "[onError] ");
                                   t.printStackTrace();
                               }

                               @Override
                               public void onNext(CurrentWeather weather) {
                                   Log.d(TAG, "[onNext] " + weather.toString());
                                   for (int appWidgetId : appWidgetIds) {
                                       updateAppWidget(context, appWidgetManager, appWidgetId, weather);
                                   }
                               }
                           }
                );

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

