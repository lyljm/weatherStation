package org.click.weatherstation.Sensor;

import org.click.weatherstation.AlarmListener;
import org.click.weatherstation.Observable;

public class TemperatureSensor extends Observable {
    double itsLastReading;

    TemperatureSensorImp temperatureSensorImp;

    public TemperatureSensor(TemperatureSensorImp temperatureSensorImp){
        this.temperatureSensorImp=temperatureSensorImp;
    }

    public void check() {
        double val = temperatureSensorImp.read();
        if (val != itsLastReading) {
            itsLastReading = val;
            notifyObservers(val);
        }
    }

    public AlarmListener createAdapter() {
        // 室内温度传感器创建一个匿名监听器，监听时频
        return new AlarmListener() {
            @Override
            public void wakeup() {
                // 判读是否变化,变化则更新
                check();
            }
        };
    }
}
