package isp.lab9.exercise2;

import isp.lab9.exercise1.Observer;

import java.util.Random;

public class Humidity implements Observer {
    private int humival = 0;

    @Override
    public void update(Object event) {
        System.out.println("Sensor status has changed!");
        System.out.println("Sensor: {HUMIDITY}" + "{" + this.humival + "}");
    }

    public void readSensor() {
        Random randval = new Random();
        humival = randval.nextInt(50);

    }
}
