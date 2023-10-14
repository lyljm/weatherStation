package org.click.weatherstation;

import org.click.weatherstation.Sensor.TemperatureSensor;

public class TestTemperatureSensor implements TemperatureSensor {
    @Override
    public double read() {
        return 0;
    }
}
