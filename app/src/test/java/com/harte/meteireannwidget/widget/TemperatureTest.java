package com.harte.meteireannwidget.widget;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TemperatureTest {
    @Test
    public void farenheitTest() {
        Temperature temp = new Temperature(new BigDecimal("20.0"));

        assertEquals("20", temp.getCelsiusStr(false));
        assertEquals("20.0", temp.getCelsiusStr(true));

        assertEquals("68", temp.getFarenheitStr(false));
    }

}