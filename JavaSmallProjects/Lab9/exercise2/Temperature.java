package isp.lab9.exercise2;

import isp.lab9.exercise1.Observer;

import java.util.Random;

public class Temperature implements Observer {

    private int tempval = 0;

    @Override
    public void update(Object event) {
        System.out.println("Sensor status has changed!");
        System.out.println("Sensor: {TEMPERATURE}" + "{" + this.tempval + "}");
    }

    public void readSensor() {
        Random randval = new Random();
        tempval = randval.nextInt(60);

    }


}
