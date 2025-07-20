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
    
    public void feedAll(food foodName) {
        for (animal a : animals ) {
            a.changeHunger(0);
            if (foodName.quantity < 0) {
                System.out.println("Not enough food!");
                break;  
            } else {
                foodName.quantity--;
            }    
        }
    }
    
}
