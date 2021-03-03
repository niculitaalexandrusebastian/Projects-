package isp.lab6.exercise1;


import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SensorCluster {
    ArrayList<Sensor> sensors = new ArrayList<>();

    public SensorCluster() {
    }


    public SensorCluster(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorCluster)) return false;
        SensorCluster that = (SensorCluster) o;
        return Objects.equals(sensors, that.sensors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensors);
    }

    public Sensor addSensor(String sensorId, SENSOR_TYPE type) {
        Sensor sensorToAdd = new Sensor(type, sensorId);
        for(int i=0;i<this.sensors.size();i++){
            if(this.sensors.get(i).getId().equals(sensorId)){
                return null;
            }
        }
        this.sensors.add(sensorToAdd);
        return sensorToAdd;
    }

    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime) {
        for (int i = 0; i < this.sensors.size(); i++) {

            if (this.sensors.get(i).getId().equals(sensorId)) {
                this.sensors.get(i).addSensorReading(new SensorReading(dateTime, value));
                return true;
            }
        }
        return false;

    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public Sensor getSensorById(String sensorId) {
        for (int i = 0; i < sensors.size(); i++) {
            if (sensors.get(i).getId().equals(sensorId))
                return sensors.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "SensorCluster{" +
                "sensors=" + sensors +
                '}';
    }



}
