import java.util.ArrayList;
import java.util.List;

public class Container {
    public int Size;
    public String Name;
    public int SpaceLeft;
    List<Animal> Animals = new ArrayList<>();
    // public String speciesContainmentIndex;

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
        
        // int timeNeeded = 1000 *60;
        
        Thread objectThreads = new Thread(() -> {
            
            int theTimeWaited = 0;
            
            while(true){
                try {
                    Thread.sleep(100);
                    theTimeWaited += 100;

                    // Here is the logic!!!
                    if (theTimeWaited > 10000) {
                        for (Animal a : this.Animals) {
                            a.changeHunger(a.HungerLevel + 1);
                            // System.out.println("Hunger Changed");
                        }
                    theTimeWaited = 0;                     
                    }    
                } catch (Exception e) {
                }
            }
        }); 
        objectThreads.start();
    }

}
