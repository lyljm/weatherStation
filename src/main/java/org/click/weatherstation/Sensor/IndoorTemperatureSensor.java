package org.click.weatherstation.Sensor;

import org.click.weatherstation.AlarmListener;
import org.click.weatherstation.Observable;

/**
 * 该类目前有三个责任
 * 1.与硬件交互读取温度值
 * 2.判断读数是否变化并调用Observable的notifyObservers
 * 3.创建并注册AlarmListener的匿名内部类
 */
public class IndoorTemperatureSensor extends Observable implements TemperatureSensor {

    @Override
    public double read() {
        return 10;
    }

    public AlarmListener createAdapter(){
        // 室内温度传感器创建一个匿名监听器，监听时频
        return new AlarmListener() {
            @Override
            public void wakeup() {
                // 判读是否变化,变化则更新
                // if()
                {
                    notifyObservers(read());
                }
            }
        };
    }
}
