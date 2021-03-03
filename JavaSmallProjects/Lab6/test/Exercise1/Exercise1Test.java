package isp.lab6.Exercise1;

import isp.lab6.exercise1.SENSOR_TYPE;
import isp.lab6.exercise1.Sensor;
import isp.lab6.exercise1.SensorCluster;
import isp.lab6.exercise1.SensorReading;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Aes128;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exercise1Test {
    @Test

    public void addSensorButShouldReturnNull() {
        Sensor s = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        assertEquals(null, sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY));


    }

    @Test
    public void addSensorButShouldReturnTheSensor() {
        Sensor s1 = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        Sensor s2 = new Sensor(SENSOR_TYPE.TEMPERATURE, "2");
        sensorCluster.addSensor("2", SENSOR_TYPE.TEMPERATURE);
        int k = 0;
        if (s2.getId().equals(sensorCluster.getSensorById("2").getId()))
            k = 1;
        assertEquals(1, k);

    }

    @Test
    public void writeSensorReadingbutNotSameId() {
        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        assertEquals("Should be false", false, sensorCluster.writeSensorReading("2", 13, LocalDateTime.now()));
    }

    @Test
    public void writeSensorReadingbutSameSameId() {
        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        assertEquals("Should be false", true, sensorCluster.writeSensorReading("1", 13, LocalDateTime.now()));
    }

    @Test
    public void getSensorByIdbutShouldReturnNULL() {
        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        assertEquals(null, sensorCluster.getSensorById("2"));
    }

    @Test
    public void getSensorByIdbutShouldReturnTrue() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        Sensor sensor = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        sensors.add(sensor);
        SensorCluster sensorCluster = new SensorCluster(sensors);
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        assertEquals(sensors.get(0), sensorCluster.getSensorById("1"));
    }

    @Test
    public void testgetSensorReadingsSortedByDateAndTime() {
        ArrayList<SensorReading> sensorsreadings = new ArrayList<>();
        SensorReading sensorReading1 = new SensorReading(LocalDateTime.now(), 22);
        SensorReading sensorReading2 = new SensorReading(LocalDateTime.of(1999, 10, 14, 12, 55), 40);

        Sensor sensor1 = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        sensor1.addSensorReading(sensorReading1);
        sensor1.addSensorReading(sensorReading2);

        sensorsreadings.add(sensorReading2);
        sensorsreadings.add(sensorReading1);


        assertEquals(sensorsreadings, sensor1.getSensorReadingsSortedByDateAndTime());

    }

    @Test
    public void testgetSensorReadingsSortedByValue() {
        ArrayList<SensorReading> sensorsreadings = new ArrayList<>();
        SensorReading sensorReading1 = new SensorReading(LocalDateTime.now(), 22);
        SensorReading sensorReading2 = new SensorReading(LocalDateTime.of(1999, 10, 14, 12, 55), 40);

        Sensor sensor1 = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        sensor1.addSensorReading(sensorReading1);
        sensor1.addSensorReading(sensorReading2);

        sensorsreadings.add(sensorReading1);
        sensorsreadings.add(sensorReading2);


        assertEquals(sensorsreadings, sensor1.getSensorReadingSortedByValeu());

    }

    @Test
    public void SensorToStringTest() {
        Sensor sensor = new Sensor(SENSOR_TYPE.HUMIDITY, "1");
        assertEquals("Sensor{" +
                "type=" + sensor.getType() +
                ", id='" + sensor.getId() + '\'' +
                '}', sensor.toString());

    }

  //  public void SensorClusterToStringTest()


}
