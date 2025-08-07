public class Animal {
    // Varible Decleration
    public String Name;
    public int Age;
    public String Species;
    public int HungerLevel = 0; // 0-10
    public boolean isContained = false;
    public String Gender;
    public String BoxContained = "Not Contained";

    // Animal Container
    public Animal(String Name, int Age, String Species, String Gender) {
        this.Name = Name;
        this.Age = Age;
        this.Species = Species;
        this.Gender = Gender;
    }

    // Hunger Setter
    public void changeHunger(int newHunger){
        this.HungerLevel = newHunger;
    }

    public void changeName(String newName){
        this.Name = newName;
    }

    @Override
    public String toString() {
        return String.format("%s is a %d year old %s", this.Name, this.Age, this.Species);
    }

}
