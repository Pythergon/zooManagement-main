
public class Animal {
    public String Name;
    public int Age;
    public String Species;
    public int HungerLevel = 0; // 0-5

    public boolean isContained = false;

    public Animal(String Name, int Age, String Species) {
        this.Name = Name;
        this.Age = Age;
        this.Species = Species;
    }

    public void changeHunger(int newHunger){
        this.HungerLevel = newHunger;
    }

    @Override
    public String toString() {
        return String.format("%s is a %d year old %s", this.Name, this.Age, this.Species);
    }

}
