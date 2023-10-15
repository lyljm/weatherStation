package org.click.weatherstation.Sensor;

import org.click.weatherstation.AlarmListener;
import org.click.weatherstation.Observable;

import java.util.Random;

/**
 * 该类目前有三个责任
 * 1.与硬件交互读取温度值
 * 2.判断读数是否变化并调用Observable的notifyObservers
 * 3.创建并注册AlarmListener的匿名内部类
 */
public class IndoorTemperatureSensor implements TemperatureSensorImp {
    private Random random = new Random();

    @Override
    public double read() {
        double val = random.nextDouble();
        return val;
    }
}
