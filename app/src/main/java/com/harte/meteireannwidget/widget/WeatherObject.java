package com.harte.meteireannwidget.widget;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class WeatherObject {

    protected String formatForStr(BigDecimal amount, boolean includeDecimal) {
        if (includeDecimal) {
            DecimalFormat df = new DecimalFormat("#,###.0");
            return df.format(amount);
        } else {
            DecimalFormat df = new DecimalFormat("#,###");
            return df.format(amount);
        }
    }
}
