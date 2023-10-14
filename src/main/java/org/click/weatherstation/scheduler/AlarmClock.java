package org.click.weatherstation.scheduler;

import org.click.weatherstation.AlarmListener;

/**
 * 只做一件事：时间调度
 */
public class AlarmClock implements Scheduler{

    public void wakeEvery(int interval, AlarmListener alarmListener) throws InterruptedException {
        while (true){
            alarmListener.wakeup();
            Thread.sleep(interval);
        }
    }

    @Override
    public void tic() {

    }
}
