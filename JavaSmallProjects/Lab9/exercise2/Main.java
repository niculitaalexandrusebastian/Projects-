package isp.lab9.exercise2;


import isp.lab9.exercise1.Observer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller();
        Temperature temperature = new Temperature();
        Humidity humidity = new Humidity();
        Pressure pressure = new Pressure();
        temperature.readSensor();
        humidity.readSensor();
        pressure.readSensor();
        controller.register((Observer) temperature);
        controller.register((Observer) humidity);
        controller.register((Observer) pressure);
        controller.startSensor();
        Thread.sleep(500);
        controller.stopSensor();


    }
}
