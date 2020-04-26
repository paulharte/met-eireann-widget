package com.harte.meteireannwidget.imageFetch;

import com.harte.meteireannwidget.R;

import javax.inject.Inject;

public class ImageFetcher {

    @Inject
    public ImageFetcher() {

    }

    public int fetchWeatherSymbol(String imageIdentifier) {

        //"@drawable/met01d"

        return R.drawable.met01n;
    }
}
