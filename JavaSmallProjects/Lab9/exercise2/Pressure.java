package isp.lab9.exercise2;

import isp.lab9.exercise1.Observer;

import java.util.Random;

public class Pressure implements Observer {
    private int pressval = 0;

    @Override
    public void update(Object event) {
        System.out.println("Sensor status has changed!");
        System.out.println("Sensor: {PRESSURE}" + "{" + this.pressval + "}");
    }

    public void readSensor() {
        Random randval = new Random();
        pressval = randval.nextInt(150);

    }
}
