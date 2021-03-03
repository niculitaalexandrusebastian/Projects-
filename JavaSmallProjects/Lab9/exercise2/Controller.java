package isp.lab9.exercise2;

import isp.lab9.exercise1.Observable;

public class Controller extends Observable {
    void startSensor() {
        System.out.println("Sensor started!");
        this.changeState("START");
    }

    void stopSensor() {
        System.out.print("Sensor stopped!");
        this.changeState("STOP");
    }
}
