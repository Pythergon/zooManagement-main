import java.util.Scanner;

public class zooManagement {
    public static void main(String[] args) {

        // Object declarations!
        Scanner scanner = new Scanner(System.in);
        animal Romeo = new animal("Romeo", 4, "Horse");
        animal Spankey = new animal("Spankey", 5, "Donkey");
        animal Bambi = new animal("Bambi", 2, "Deer");
        container Conatainer1 = new container(2);
        food Hay = new food("Hay",10);

        Conatainer1.containAnimal(Bambi);

        // Game loop - when I get home though lol

        Boolean running = true;

        while (running) {
            // Output current state
            for (animal a: Conatainer1.animals){
                System.out.println(a.name);
            }
            // Get user input
            System.out.println("Would you like to add an animal to a container");
            String userInput = scanner.nextLine(); 
            // Update game state (Based on user input)
            for (animal a : Conatainer1.animals) {
                if (a.name == userInput){
                    Conatainer1.containAnimal(a);
                }
            }

            running = false;
        }

    }
}
