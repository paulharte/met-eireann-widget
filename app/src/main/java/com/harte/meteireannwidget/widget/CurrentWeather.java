package com.harte.meteireannwidget.widget;

public class CurrentWeather {

    int symbol;
    String description;
    Temperature temperature;
    Wind wind;

    public CurrentWeather( int symbol, String description, Temperature temperature, Wind wind) {
        this.symbol = symbol;
        this.description = description;
        this.temperature = temperature;
        this.wind = wind;
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
