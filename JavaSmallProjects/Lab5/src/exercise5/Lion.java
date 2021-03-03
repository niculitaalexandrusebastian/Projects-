package isp.lab5.exercise5;

import java.util.Random;

public class Lion extends Animal implements Carnivorous {
    private int index;

    public Lion(String species, int age, int index) {
        super(species, age);
        this.index = index;
    }

    Random x = new Random();
    private int chancestoHuntSuccesfully = x.nextInt(100);

    @Override
    void eat() {
        System.out.println("Lion eat meat");
    }

    @Override
    public void huntSuccesfully() {
        System.out.println("Lion " + index + " hunt succesfully at age" + "{" + age + "}" + "with a chance of " + chancestoHuntSuccesfully);

    }

    @Override
    public void huntFailed() {
        System.out.println("Lion " + index + " hunt failed at age" + "{" + age + "}" + "with a chance of " + chancestoHuntSuccesfully);

    }

    @Override
    public int getChangesToHuntSuccesfully() {
        return chancestoHuntSuccesfully;
    }
}
