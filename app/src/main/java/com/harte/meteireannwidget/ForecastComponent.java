package com.harte.meteireannwidget;

import com.harte.meteireannwidget.imageFetch.ImageFetcher;
import com.harte.meteireannwidget.widget.ForecastService;
import dagger.Component;

@Component //(modules={ForecastModule.class})
public interface ForecastComponent {
    ForecastService getForecastService();
    ImageFetcher getImageFetcher();


}
