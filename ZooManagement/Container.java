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
    
}
