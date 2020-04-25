package com.harte.meteireannwidget.met;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForecastServiceTest {

    @Test
    public void getMetForecast() {
    }

    @Test
    public void getShortForecast() {
        ForecastService service = new ForecastService();
        CurrentObservation shortf = service.getShortForecast(County.Dublin);
        System.out.print(shortf);
        assertNotNull(shortf);
    }
}