import java.util.ArrayList;
import java.util.List;

public class Container {
    // Varible Decleration
    public int Size;
    public String Name;
    public int SpaceLeft;
    List<Animal> Animals = new ArrayList<>();
    // public String speciesContainmentIndex;

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
        } else {
            System.out.println("Container outta space!");
        }
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
        Thread objectThreads = new Thread(() -> {            
            int timeWaited = 0;
            while(true){
                try {
                    // 100 MS timesteps
                    Thread.sleep(100);
                    timeWaited += 100;
                    // Update Hunger
                    if (timeWaited > 15000) {
                        for (Animal a : this.Animals) {
                            a.changeHunger(a.HungerLevel + 1);
                            System.out.println(a.Name + " got hungry inside of " + this.Name);
                            if (a.HungerLevel > 10) {
                                this.Animals.remove(a);
                                System.out.println("Yeah he died :) ");
                                this.SpaceLeft -= 1;
                            }
                        }
                    timeWaited = 0;                     
                    }    
                    // Lose State
                    if (this.Animals.isEmpty()){
                        System.out.println("You Lost!");
                        System.out.println("All animals got lost or died!");
                        System.exit(1);
                    }
                } catch (Exception e) {
                }
            }
        }); 
        objectThreads.start();
    }

}
