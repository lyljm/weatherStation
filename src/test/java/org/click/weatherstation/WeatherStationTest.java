package org.click.weatherstation;

import org.click.weatherstation.Sensor.IndoorTemperatureSensor;
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
        // 向温度传感器添加订阅者：温度观察适配器
        indoorTemperatureSensor.addObserver(monitoringScreen.createTempObserver());
        // 创建scheduler
        AlarmClock alarmClock=new AlarmClock();
        // 向scheduler中添加监听器
        alarmClock.wakeEvery(1000, indoorTemperatureSensor.createAdapter());

    }
}
