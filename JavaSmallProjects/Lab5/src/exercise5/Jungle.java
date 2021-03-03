package isp.lab5.exercise5;

public class Jungle {
    private Herbivorous[] herbivores;
    private Carnivorous[] carnivores;

    public Jungle(Herbivorous[] herbivores, Carnivorous[] carnivores) {
        this.carnivores = carnivores;
        this.herbivores = herbivores;

    }

    public void removeAnimalFromHerbivores(int index) {
        herbivores[index] = null;
    }

    public void removeAnimalFromCarnivores(int index) {
        carnivores[index] = null;

    }

}
