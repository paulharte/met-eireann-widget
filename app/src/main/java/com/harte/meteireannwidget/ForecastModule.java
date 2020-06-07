package com.harte.meteireannwidget;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ForecastModule {

    private Context context;

    public ForecastModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext() {
        return context;
    }

}
