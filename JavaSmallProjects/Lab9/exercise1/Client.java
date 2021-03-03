package isp.lab9.exercise1;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Alarm fireAlarm = new Alarm();
        AlarmMonitor monitor = new AlarmMonitor();
        AlarmController controller = new AlarmController();
        fireAlarm.register((Observer) monitor);
        fireAlarm.register((Observer) controller);
        fireAlarm.startAlarm();
        Thread.sleep(500);
        fireAlarm.stopAlarm();

    }

}
