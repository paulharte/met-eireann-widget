package com.harte.meteireannwidget.widget;

import java.math.BigDecimal;
import java.text.DecimalFormat;

class Temperature extends WeatherObject{

    private BigDecimal celsius;

    public Temperature(BigDecimal celsius) {
        this.celsius = celsius;
    }

    public BigDecimal getcelsius() {
        return celsius;
    }

    public BigDecimal getFarenheit() {
        return (this.celsius.multiply(new BigDecimal(1.8))).add( new BigDecimal(32.0));
    }

    public String getCelsiusStr(boolean includeDecimal) {
        return this.formatForStr(this.getcelsius(), includeDecimal);
    }

    public String getFarenheitStr(boolean includeDecimal) {
        return this.formatForStr(this.getFarenheit(), includeDecimal);
    }

}
