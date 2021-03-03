package isp.lab5.exercise5;

public abstract class Animal {
    protected String species;
    protected int age;

    protected Animal(String Species, int age) {
        this.species = Species;
        this.age = age;
    }

    abstract void eat();

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
}
