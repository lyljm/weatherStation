package org.click.weatherstation;

import org.click.weatherstation.Sensor.IndoorTemperatureSensor;
import org.click.weatherstation.Sensor.TemperatureSensor;
import org.click.weatherstation.monitoring.MonitoringScreen;
import org.click.weatherstation.observer.Observer;
import org.click.weatherstation.scheduler.AlarmClock;
import org.junit.Test;

public class WeatherStationTest {
    @Test
    public void test() throws InterruptedException {
        // 显示器
        MonitoringScreen monitoringScreen = new MonitoringScreen();
        // 温度传感器
        IndoorTemperatureSensor indoorTemperatureSensor = new IndoorTemperatureSensor();
        // 温度传感器桥
        TemperatureSensor temperatureSensor=new TemperatureSensor(indoorTemperatureSensor);
        // 向发布者添加观察者
        temperatureSensor.addObserver(monitoringScreen.createTempObserver());
        // 创建scheduler
        AlarmClock alarmClock=new AlarmClock();
        // 向scheduler中添加监听器
        alarmClock.wakeEvery(1000, temperatureSensor.createAdapter());

    }
}
