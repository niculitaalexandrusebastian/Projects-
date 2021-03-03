package isp.lab9.exercise1;

public class AlarmController implements Observer {

    @Override
    public void update(Object event) {
        System.out.println("Alarm status has changed!");
        System.out.println("Sending SMS message to owner.");
    }
}
