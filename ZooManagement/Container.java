import java.util.ArrayList;
import java.util.List;

public class Container {
    // Variable Declaration
    public int Size;
    public String Name;
    public int SpaceLeft;
    public boolean hasAnimals;
    List<Animal> Animals = new ArrayList<>();

    // Object Container
    public Container(int Size, String Name) {
        this.Size = Size;
        this.Name = Name;
        this.SpaceLeft = Size;
    }

    public void containAnimal(Animal animalName) {
        if (this.SpaceLeft >= 1){
            this.Animals.add(animalName);
            animalName.isContained = true;
            this.SpaceLeft--;
            animalName.BoxContained = this.Name;
        } else {
            System.out.println("Container outta space!");
        }
    }

    public void removeAnimal(Animal animal){
        this.Animals.remove(animal);
    }

    public void feedAll(Food foodName) {
        for (Animal a : Animals ) {
            a.changeHunger(0);
            if (foodName.Quantity < 0) {
                System.out.println("Outta food bro!");
                break;  
            } else {
                foodName.Quantity--;
            }    
        }
    }
    
    public void runTimeLoops() {
        // Creating a new thread per container and running the time based logic
        // Makes Animals Hungry After so long
        Thread objectThreads = new Thread(() -> {            
            int timeWaited = 0;
            while(true){
                try {
                    this.hasAnimals = !this.Animals.isEmpty();
                    // 100 MS timesteps
                    Thread.sleep(100);
                    timeWaited += 100;
                    // Update Hunger after X number of milliseconds
                    if (timeWaited > 15000) {
                        for (Animal a : this.Animals) {
                            a.changeHunger(a.HungerLevel + 1);
                            System.out.println(a.Name + " got hungry inside of " + this.Name);
                            if (a.HungerLevel >= 10) {
                                this.Animals.remove(a);
                                a.BoxContained = "Not Contained";
                                System.out.println("Yeah he died :( ");
                                this.SpaceLeft -= 1;
                            }
                        }
                    timeWaited = 0;                     
                    }
                } catch (Exception ignored) {
                }
            }
        }); 
        objectThreads.start();
    }
}
