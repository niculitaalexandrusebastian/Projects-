package isp.lab5.exercise5;

import java.util.Random;

public class Tiger extends Animal implements Carnivorous {

    private int index;

    public Tiger(String species, int age, int index) {
        super(species, age);
        this.index = index;
    }

    Random x = new Random();
    private int chancestoHuntSuccesfully = x.nextInt(100);

    @Override
    void eat() {
        System.out.println("Tiger eat meat");
    }

    @Override
    public void huntSuccesfully() {
        System.out.println("Tiger " + index + " hunt succesfully at age" + "{" + age + "}" + "with a chance of " + chancestoHuntSuccesfully);

    }

    @Override
    public void huntFailed() {
        System.out.println("Tiger " + index + " hunt failed at age" + "{" + age + "}" + "with a chance of " + chancestoHuntSuccesfully);

    }

    @Override
    public int getChangesToHuntSuccesfully() {
        return chancestoHuntSuccesfully;
    }
}
