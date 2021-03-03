package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {


    public static void main(String[] args) {
        int indexThreads = 0;
        List<Aircraft> aircrafts = new ArrayList<>();
        ATC atc = new ATC(aircrafts);
        List<Thread> threads = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int option;
        String aircraftId;

        for (; ; ) {
            System.out.println("Choose an option:");
            System.out.println("0.Exit");
            System.out.println("1.Add Aircraft");
            System.out.println("2.Send Command Take_OFF");
            System.out.println("3.Send Command Land");
            System.out.println("4.Show Aircrafts");
            option = in.nextInt();

            switch (option) {
                case 0: {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                case 1: {
                    System.out.println("Give an Id");
                    aircraftId = in.next();
                    atc.addAircraft(aircraftId);
                    if (aircrafts.contains(new Aircraft(aircraftId))) {
                        threads.add(new Thread(new Aircraft(aircraftId)));
                        threads.get(indexThreads).start();
                        indexThreads++;
                    }
                    break;
                }

                case 2: {
                    System.out.println("Give an Id to Take_OFF");
                    aircraftId = in.next();
                    System.out.println("Give an altitude:");
                    int altitude = in.nextInt();
                    AtcCommand atcCommand = new TakeoffCommand("take_off", altitude);

                    atc.sendCommand(aircraftId, atcCommand);

                    break;
                }
                case 3: {
                    System.out.println("Give an Id to Land");
                    aircraftId = in.next();
                    LandCommand landCommand = new LandCommand("land");
                    atc.sendCommand(aircraftId, landCommand);
                    break;
                }

                case 4: {
                    atc.showAircrafts();
                }

            }
        }

    }
}
