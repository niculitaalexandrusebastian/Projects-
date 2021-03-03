package isp.lab5.exercise5;

import java.util.Random;


public class Elk extends Animal implements Herbivorous {
    private int index;

    public Elk(String species, int age, int index) {
        super(species, age);
        this.index = index;
    }

    Random x = new Random();
    private int chancestorunSuccesfully = x.nextInt(100);


    @Override
    void eat() {
        System.out.println("Elk eat grass");
    }

    @Override
    public int getChancesToRunSuccesfully() {
        return chancestorunSuccesfully;
    }


    @Override
    public void runSuccesfully() {
        System.out.println("Elk " + index + " run succesfully at age" + "{" + age + "}" + "with a chance of " + chancestorunSuccesfully);

    }

    @Override
    public void runFailed() {
        System.out.println("Elk " + index + " run failed at age" + "{" + age + "}" + "with a chance of " + chancestorunSuccesfully);


    }


}

