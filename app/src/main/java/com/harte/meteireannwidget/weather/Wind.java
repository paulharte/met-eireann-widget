package com.harte.meteireannwidget.weather;

import java.math.BigDecimal;

public class Wind extends WeatherObject {

    private BigDecimal windSpeedKm;
    private String windDescription;
    private BigDecimal windDirectionDegrees;

    public Wind(BigDecimal windSpeedKm, BigDecimal windDirectionDegrees) {
        this.windSpeedKm = windSpeedKm;
        this.windDescription = windDescription;
        this.windDirectionDegrees = windDirectionDegrees;
    }

    //TODO: windspeed in MPH

    public BigDecimal getWindSpeedKm() {
        return windSpeedKm;
    }

    public String getWindSpeedKmStr(boolean includesDecimal) {
        return this.formatForStr(this.windSpeedKm, includesDecimal);
    }

    public void setWindSpeedKm(BigDecimal windSpeedKm) {
        this.windSpeedKm = windSpeedKm;
    }

    public String getWindDescription() {
        return windDescription;
    }

    public void setWindDescription(String windDescription) {
        this.windDescription = windDescription;
    }

    public BigDecimal getWindDirectionDegrees() {
        return windDirectionDegrees;
    }

    public void setWindDirectionDegrees(BigDecimal windDirectionDegrees) {
        this.windDirectionDegrees = windDirectionDegrees;
    }
}
