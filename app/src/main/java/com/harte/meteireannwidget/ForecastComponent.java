package com.harte.meteireannwidget;

import android.content.Context;

import com.harte.meteireannwidget.imageFetch.ImageFetcher;
import com.harte.meteireannwidget.widget.ForecastService;
import dagger.Component;

@Component(modules={ForecastModule.class})
public interface ForecastComponent {
    void inject(Context context);
    ForecastService getForecastService();
    ImageFetcher getImageFetcher();
    Context getContext();

}
