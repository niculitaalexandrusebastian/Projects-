package isp.lab5.exercise5;

import java.util.Random;


public class Simulator {
    private Carnivorous[] carnivores = new Carnivorous[20];
    private Herbivorous[] herbivores = new Herbivorous[20];
    private Jungle j;

    private int maxchanceherbivores = 0;
    private int maxchancecarnivores = 0;
    Random x = new Random();
    boolean chooseherbivor;
    boolean choosecarnivor;
    int randage;

    public Simulator() {
        for (int i = 0; i < herbivores.length; i++) {
            chooseherbivor = x.nextBoolean();
            randage = x.nextInt(40);
            if (!chooseherbivor) {
                herbivores[i] = new Deer("Deer", randage, i);

            } else {
                herbivores[i] = new Elk("Elk", randage, i);
            }
            if (herbivores[i].getChancesToRunSuccesfully() > maxchanceherbivores)
                maxchanceherbivores = herbivores[i].getChancesToRunSuccesfully();


        }
        for (int i = 0; i < carnivores.length; i++) {
            choosecarnivor = x.nextBoolean();
            randage = x.nextInt(40);
            if (!choosecarnivor) {
                carnivores[i] = new Lion("Lion", randage, i);
            } else {
                carnivores[i] = new Tiger("Tiger", randage, i);
            }
            if (carnivores[i].getChangesToHuntSuccesfully() > maxchancecarnivores)
                maxchancecarnivores = carnivores[i].getChangesToHuntSuccesfully();

        }
    }

    int indexc;
    int indexh;
    boolean draw = false;
    boolean checkherbivores = false;
    boolean checkcarnivores = false;
    boolean condition = false;

    public void simulate() {
        j = new Jungle(herbivores, carnivores);

        if (maxchancecarnivores == maxchanceherbivores) {
            draw = true;

        }
        int k = 0;

        while (carnivores != null && herbivores != null) {
            indexc = x.nextInt(20);
            indexh = x.nextInt(20);


            for (int i = 0; i < herbivores.length; i++) {
                if (herbivores[i] != null) {
                    checkherbivores = true;
                    break;
                }
            }
            for (int j = 0; j < carnivores.length; j++) {
                if (carnivores[j] != null) {
                    checkcarnivores = true;
                    break;
                }
            }
            if ((herbivores[indexh] != null) && (carnivores[indexc] != null)) {
                condition = true;
            }

            if ((condition) && (herbivores[indexh].getChancesToRunSuccesfully() > carnivores[indexc].getChangesToHuntSuccesfully())) {
                herbivores[indexh].runSuccesfully();
                carnivores[indexc].huntFailed();
                System.out.println("Elimin elem" + indexc);
                j.removeAnimalFromCarnivores(indexc);
                System.out.println("\n");

            } else if ((condition) && (herbivores[indexh].getChancesToRunSuccesfully() < carnivores[indexc].getChangesToHuntSuccesfully())) {
                carnivores[indexc].huntSuccesfully();
                herbivores[indexh].runFailed();
                System.out.println("Elimin elem" + indexh);
                j.removeAnimalFromHerbivores(indexh);
                System.out.println("\n");

            } else if ((condition) && (herbivores[indexh].getChancesToRunSuccesfully() == carnivores[indexc].getChangesToHuntSuccesfully()) && (draw)) {
                System.out.println("It's a draw!");
                break;
            }


            if (!checkcarnivores) {
                carnivores = null;
            }
            if (!checkherbivores) {
                herbivores = null;
            }

            condition = false;
            checkherbivores = false;
            checkcarnivores = false;
        }


        if (carnivores == null) {
            System.out.println("Herbivores win");
        }
        if (herbivores == null) {
            System.out.println("Carnivores win");
        }

    }

}