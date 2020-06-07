package com.harte.meteireannwidget.imageFetch;

import android.content.Context;

import com.harte.meteireannwidget.R;

import javax.inject.Inject;

public class ImageFetcher {
    private final Context context;

    @Inject
    public ImageFetcher(Context context) {
        this.context = context;

    }

    public int fetchWeatherSymbol(String imageIdentifier) {

        //"@drawable/met01d"
        // input: 05d

        String fullFileName = this.formFileName(imageIdentifier);

        int imageId = this.context.getResources().getIdentifier(fullFileName, "drawable", context.getPackageName());
        if (imageId == 0) {
            String message = "Cannot find image of filename: " + fullFileName;
            throw new ImageNotFoundException(message);
        }
        return imageId;
    }

    private String formFileName(String imageIdentifier) {
        return "met".concat(imageIdentifier);
    }
}
