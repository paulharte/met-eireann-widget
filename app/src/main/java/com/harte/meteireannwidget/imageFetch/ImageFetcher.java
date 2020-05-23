package com.harte.meteireannwidget.imageFetch;

import com.harte.meteireannwidget.R;

import javax.inject.Inject;

public class ImageFetcher {

    @Inject
    public ImageFetcher() {

    }

    public int fetchWeatherSymbol(String imageIdentifier) {

        //"@drawable/met01d"
        // input: 05d
        // https://stackoverflow.com/questions/26947392/iterate-through-certain-images-in-res-drawable-mdpi

        return R.drawable.met01n;
    }
}
