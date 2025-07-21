import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooManagement {
    public static void main(String[] args) {

        // Object declarations!
        Scanner scanner = new Scanner(System.in);
        animal Romeo = new animal("Romeo", 4, "Horse");
        animal Spankey = new animal("Spankey", 5, "Donkey");
        animal Bambi = new animal("Bambi", 2, "Deer");
        container Container1 = new container(2);
        food Hay = new food("Hay",10);

        // Animal list - crucial for checking
        List<animal> animals = new ArrayList<>();        
        animals.add(Romeo);
        animals.add(Spankey);
        animals.add(Bambi);

        List<container> containers = new ArrayList<>();
        containers.add(Container1);
        Container1.containAnimal(Bambi);

        Boolean running = true;

        while (running) {
            // Output current state
            System.out.println(Container1.animals.toString());
            System.out.println(animals.toString());

            // Get user input
            System.out.println("What would you like to-do?");
            String userInput = scanner.nextLine(); 

            // Update game state (Based on user input)
            switch (userInput) {
                case "Add Animal":
                    System.out.println("What animal would you like to add?");
                    userInput = scanner.nextLine();
                    for (animal a : animals) {
                        if (a.name.equals(userInput)) {
                            Container1.containAnimal(a);
                        }
                    }
                    break;
                default:
                    System.out.println("Function Not-Found");
                    break;
            }   

            //running = false;
        }
        scanner.close();
    }
}
