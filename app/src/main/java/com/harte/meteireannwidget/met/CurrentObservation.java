package com.harte.meteireannwidget.met;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortForecast {

    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("temperatureClass")
    @Expose
    private String temperatureClass;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("weatherDescription")
    @Expose
    private String weatherDescription;
    @SerializedName("weather")
    @Expose
    private String weather;
    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("windGust")
    @Expose
    private Object windGust;
    @SerializedName("windDirection")
    @Expose
    private Integer windDirection;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("rainfall")
    @Expose
    private String rainfall;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("canonicalWindDirection")
    @Expose
    private String canonicalWindDirection;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("highestWarning")
    @Expose
    private String highestWarning;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureClass() {
        return temperatureClass;
    }

    public void setTemperatureClass(String temperatureClass) {
        this.temperatureClass = temperatureClass;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Object getWindGust() {
        return windGust;
    }

    public void setWindGust(Object windGust) {
        this.windGust = windGust;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getCanonicalWindDirection() {
        return canonicalWindDirection;
    }

    public void setCanonicalWindDirection(String canonicalWindDirection) {
        this.canonicalWindDirection = canonicalWindDirection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHighestWarning() {
        return highestWarning;
    }

    public void setHighestWarning(String highestWarning) {
        this.highestWarning = highestWarning;
    }

}