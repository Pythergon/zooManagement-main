import java.util.List;

public class Food {
    // Varible Decleration
    public String FoodName;
    public int Quantity;

    // Object Container
    Food(List<Food> zooList, String FoodName, int Quantity) {
        zooList.add(this);
        this.FoodName = FoodName;
        this.Quantity = Quantity;
    }
}
