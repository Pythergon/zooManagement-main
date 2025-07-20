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

    public void containAnimal(container containerName, animal animalName) {
        if (containerName.spaceLeft >= 1){
            containerName.animals.add(animalName);
            animalName.isContained = true;
            containerName.spaceLeft--;
        } else {
            System.out.println("Container outta space!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s is a %d year old %s", this.name, this.age, this.species);
    }

}
