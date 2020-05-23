package com.harte.meteireannwidget.widget;

import com.harte.meteireannwidget.weather.Wind;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WindTest {

    @Test
    public void getWindSpeedKmStr() {
        Wind w = new Wind(new BigDecimal("10.0000"), new BigDecimal("10.0000"));
        assertEquals("10.0", w.getWindSpeedKmStr(true));
    }
}