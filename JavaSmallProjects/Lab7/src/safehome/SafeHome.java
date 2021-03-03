package isp.lab7.safehome;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SafeHome {

    public static void main(String[] args) {


        DoorLockController doorLockController = new DoorLockController();

        String pin;
        String nume;
        for (; ; ) {
            System.out.println("Choose an option:");
            System.out.println("0. Exit");
            System.out.println("1. Enter Pin");
            System.out.println("2. Add tenant");
            System.out.println("3. Call the Master");
            System.out.println("4. Remove tenant");
            System.out.println("5. Get Acces Log");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();

            switch (option) {
                case 0: {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                case 1: {
                    System.out.println("Give a pin");
                    pin = in.next();
                    try {
                        doorLockController.enterPin(pin);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }


                case 2: {
                    System.out.println("Give a pin");
                    pin = in.next();
                    System.out.println("Give a TenantName");
                    nume = in.next();
                    try {
                        doorLockController.addTenant(pin, nume);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }

                case 3: {
                    try {
                        doorLockController.enterPin(ControllerInterface.MASTER_KEY);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                }
                case 4: {
                    System.out.println("Give a name");
                    nume = in.next();
                    try {
                        doorLockController.removeTenant(nume);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                }

                case 5: {
                    System.out.println(doorLockController.getAccessLogs());
                    break;

                }
            }

        }


    }
}