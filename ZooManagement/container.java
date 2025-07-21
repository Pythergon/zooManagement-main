import java.util.ArrayList;
import java.util.List;

public class container {
    public int size;
    public int spaceLeft;
    List<animal> animals = new ArrayList<>();
    // public String speciesContainmentIndex;

    public container(int size) {
        this.size = size;
        this.spaceLeft = size;
    }

    public void containAnimal(animal animalName) {
        if (this.spaceLeft >= 1){
            this.animals.add(animalName);
            animalName.isContained = true;
            this.spaceLeft--;
        } else {
            System.out.println("Container outta space!");
        }
    }

    public void feedAll(food foodName) {
        for (animal a : animals ) {
            a.changeHunger(0);
            if (foodName.quantity < 0) {
                System.out.println("Outta food bro!");
                break;  
            } else {
                foodName.quantity--;
            }    
        }
    }
    
}
