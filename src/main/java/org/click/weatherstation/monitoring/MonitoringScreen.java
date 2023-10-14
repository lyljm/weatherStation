package org.click.weatherstation.monitoring;

import org.click.weatherstation.observer.Observer;

public class MonitoringScreen {
    public void displayTemp(double temp){
        System.out.println("MonitoringScreen to displayTemp: "+temp);
    }

    public Observer createTempObserver() {
        // 温度观察适配器
        return new Observer() {
            @Override
            public void update(double val) {
                displayTemp(val);
            }
        };
    }
}
