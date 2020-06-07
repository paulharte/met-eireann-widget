package com.harte.meteireannwidget.imageFetch;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(String filename) {
        super(filename);
    }
}
