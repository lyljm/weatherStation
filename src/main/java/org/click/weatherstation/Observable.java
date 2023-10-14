package org.click.weatherstation;

import org.click.weatherstation.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private static List<Observer>observers=new ArrayList<>();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void notifyObservers(double val){
        observers.forEach(observer -> {
            observer.update(val);
        });
    }
}
