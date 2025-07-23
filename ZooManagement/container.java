import java.util.ArrayList;
import java.util.List;

public class container {
    public int Size;
    public String Name;
    public int SpaceLeft;
    List<animal> Animals = new ArrayList<>();
    // public String speciesContainmentIndex;

    public container(int Size, String Name) {
        this.Size = Size;
        this.Name = Name;
        this.SpaceLeft = Size;
    }

    public void containAnimal(animal animalName) {
        if (this.SpaceLeft >= 1){
            this.Animals.add(animalName);
            animalName.isContained = true;
            this.SpaceLeft--;
        } else {
            System.out.println("Container outta space!");
        }
    }

    public void feedAll(food foodName) {
        for (animal a : Animals ) {
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
