package isp.lab6.exercise1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sensor {
    private SENSOR_TYPE type;
    private String id;
    private ArrayList<SensorReading> sensorReadings = new ArrayList<>();

    public Sensor(SENSOR_TYPE type, String id) {
        this.type = type;
        this.id = id;
    }

    public Sensor(SENSOR_TYPE type, String id, ArrayList<SensorReading> sensors) {
        this.type = type;
        this.id = id;
        this.sensorReadings = sensors;

    }

    public void setType(SENSOR_TYPE type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(ArrayList<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }

    public SENSOR_TYPE getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public ArrayList<SensorReading> getSensorReadingsSortedByDateAndTime() {
        Collections.sort(sensorReadings);
        return this.sensorReadings;
    }

    public ArrayList<SensorReading> getSensorReadingSortedByValeu() {
        Collections.sort(this.sensorReadings, new Comparator<SensorReading>() {
            @Override
            public int compare(SensorReading s1, SensorReading s2) {
                if (s1.getValue() - s2.getValue() < 0.01) {
                    return -1;
                } else if (s1.getValue() - s2.getValue() > 0.01) {
                    return 1;
                }
                return 0;
            }
        });
        return this.sensorReadings;
    }


    public boolean addSensorReading(SensorReading sensorReading) {
        if (sensorReading != null) {
            sensorReadings.add(sensorReading);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "type=" + type +
                ", id='" + id + '\'' +
                '}';
    }
}
