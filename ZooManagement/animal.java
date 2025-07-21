public class animal {
    public String name;
    public int age;
    public String species;
    public int hungerLevel = 0; // 0-5

    public boolean isContained = false;

    public animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public void changeHunger(int newHunger){
        this.hungerLevel = newHunger;
    }

    @Override
    public String toString() {
        return String.format("%s is a %d year old %s", this.name, this.age, this.species);
    }

}
