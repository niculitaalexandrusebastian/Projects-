package isp.lab6.exercise1;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SensorReading implements Comparable<SensorReading> {
    LocalDateTime dateAndTime;
    double value;

    public SensorReading(LocalDateTime date, double value) {
        this.dateAndTime = date;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "dateAndTime=" + dateAndTime +
                ", value=" + value +
                '}';
    }

    public LocalDateTime getDateAndTime() {
        return this.dateAndTime;
    }

    public double getValue() {
        return value;
    }

    public int compareTo(SensorReading s) {
        return this.dateAndTime.compareTo(s.getDateAndTime());

    }


}
