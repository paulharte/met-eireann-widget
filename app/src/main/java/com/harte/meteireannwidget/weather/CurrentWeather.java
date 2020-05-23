package com.harte.meteireannwidget.weather;

import com.harte.meteireannwidget.met.County;
import com.harte.meteireannwidget.weather.Temperature;
import com.harte.meteireannwidget.weather.Wind;

public class CurrentWeather {

    int symbol;
    String description;
    Temperature temperature;
    Wind wind;
    County county;

    public CurrentWeather( int symbol, String description, Temperature temperature, Wind wind, County county) {
        this.symbol = symbol;
        this.description = description;
        this.temperature = temperature;
        this.wind = wind;
        this.county = county;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return String.format("Current weather: %d", this.symbol);
    }
}
