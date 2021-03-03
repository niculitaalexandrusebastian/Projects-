package isp.lab6.exercise1;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {

        SensorReading sr1 = new SensorReading(LocalDateTime.of(2015, 11, 10, 14, 12), 22.5);
        SensorReading sr2 = new SensorReading(LocalDateTime.of(2019, 06, 25, 20, 15), 19.7);
        Sensor sensor1 = new Sensor(SENSOR_TYPE.HUMIDITY, "1");

        sensor1.addSensorReading(sr1);
        sensor1.addSensorReading(sr2);

        SensorReading sr3 = new SensorReading(LocalDateTime.of(2019, 11, 30, 12, 54), 21.3);
        SensorReading sr4 = new SensorReading(LocalDateTime.of(2015, 02, 21, 18, 43), 20.5);
        Sensor sensor2 = new Sensor(SENSOR_TYPE.TEMPERATURE, "2");

        sensor2.addSensorReading(sr3);
        sensor2.addSensorReading(sr4);

        SensorCluster sensorCluster = new SensorCluster();
        sensorCluster.addSensor("1", SENSOR_TYPE.HUMIDITY);
        sensorCluster.addSensor("2", SENSOR_TYPE.TEMPERATURE);


        System.out.println(sensor1.getSensorReadingSortedByValeu());
        System.out.println(sensor2.getSensorReadingsSortedByDateAndTime());
        sensorCluster.addSensor("3", SENSOR_TYPE.HUMIDITY);
        sensorCluster.writeSensorReading("3", 25, LocalDateTime.of(2000, 10, 13, 12, 00));
        System.out.println(sensorCluster.getSensorById("3").getSensorReadings());
        System.out.println(sensorCluster.addSensor("2", SENSOR_TYPE.HUMIDITY));
        System.out.println(sensorCluster.getSensorById("1"));


/*
        for (; ; ) {
            System.out.println("Choose an option:");
            System.out.println(" 1.Sort and Print Sensors by DateAndTime");
            System.out.println(" 2.Sort and Print Sensors by Value");
            System.out.println(" 3.Add Sensor Readings");
            System.out.println(" 4.Add Sensor");
            System.out.println(" 5.Write Sensor Readings");
            System.out.println(" 6.Get Sensor by Id");
            System.out.println(" 7.Exit");

            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            switch (option) {
                case 1: {
                    int k = 0;
                    if (!sensorCluster.equals(null))
                        k = 1;
                    if (k == 1) {

                        System.out.println("Which sensor do you wanna sort ? " + k + "..." + sensorCluster.getSensors().size());
                        String i;
                        i = in.next();
                        if (!sensorCluster.getSensorById(i).equals(null)) {
                            System.out.println(sensorCluster.getSensorById(i).getSensorReadingsSortedByDateAndTime());
                            break;
                        } else {
                            System.out.println("Error! We don't have sensor " + i);
                            //  System.out.println(sensor1.getSensorReadingsSortedByDateAndTime());
                            break;
                        }
                    }
                    System.out.println("Error! No sensors!");
                    break;
                }

                case 2: {
                    System.out.println();
                    break;
                }
                case 3: {


                    break;
                }
                case 4: {

                    break;
                }
                case 5: {

                    int id = in.nextInt();

                    break;
                }

                case 6: {
                    int id = in.nextInt();

                    break;
                }
                case 7: {
                    System.out.println("Goodbye");
                    System.exit(0);
                }

            }
        }
    }
*/
    }
}
