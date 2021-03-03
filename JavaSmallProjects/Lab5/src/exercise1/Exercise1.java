package isp.lab5.exercise1;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Account[] account = new Account[3];
        Card card0 = new Card("32121", "0000");
        account[0] = new Account(card0, "Lionel Messi", 684373);

        Card card1 = new Card("22357", "0011");
        account[1] = new Account(card1, "Cristiano Ronaldo", 123145);

        Card card2 = new Card("55335", "1474");
        account[2] = new Account(card2, "Ronaldo Nazario", 146632);

        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);

        Scanner in = new Scanner(System.in);
        String pin = null;
        int i = 3;
        int j = 0;
        int option = 1;
        double amount;
        String newpin;
        System.out.println("Insert card's pin:");
        while (i != 0) {
            pin = in.next();
            j = i - 1;
            if (pin.equals(card0.getPin())) {
                break;
            } else {
                System.out.println("Wrong PIN. You have " + j + " more tries.");
            }
            i--;
        }
        if (i == 0) {
            System.out.println("Inserted wrong PIN 3 times. Card blocked.");
        } else {
            atm.insertCard(card0, pin);
        }
        int choosecard = 0;
        while (option >= 1 && option <= 6) {
            atm.usermenu();
            option = in.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Insert the amount of money you want to withdraw:");
                    amount = in.nextDouble();
                    atm.withdraw(amount);
                    break;
                }
                case 2: {
                    System.out.println("Insert the new pin:");
                    newpin = in.next();
                    atm.changePin(card0.getPin(), newpin);
                    break;
                }
                case 3: {
                    atm.checkMoney();
                    break;
                }
                case 4: {
                    atm.removeCard();
                    break;
                }
                case 5: {
                    System.out.println("Your current pin is: " + card0.getPin());
                    break;
                }
                case 6: {
                    System.out.println("Choose which card to insert:");
                    choosecard = in.nextInt();
                    if (choosecard == 1) {
                        System.out.println("Insert pin:");
                        newpin = in.next();
                        atm.insertCard(card0, newpin);
                    }
                    if (choosecard == 2) {
                        System.out.println("Insert pin:");
                        newpin = in.next();
                        atm.insertCard(card1, newpin);
                    }
                    if (choosecard == 3) {
                        System.out.println("Insert pin:");
                        newpin = in.next();
                        atm.insertCard(card2, newpin);
                    }
                    break;

                }
                default: {
                    option = 0;
                    break;
                }
            }
        }


    }


}

