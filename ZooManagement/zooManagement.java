import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooManagement {
    public static void main(String[] args) {

        // Object declarations!
        Scanner scanner = new Scanner(System.in);
        Animal romeo = new Animal("Romeo", 4, "Horse");
        Animal spankey = new Animal("Spankey", 5, "Donkey");
        Animal bambi = new Animal("Bambi", 2, "Deer");
        Container container1 = new Container(2, "Container1");
        Food Hay = new Food("Hay",100);

        // Animal list - crucial for checking
        List<Animal> Animals = new ArrayList<>();        
        Animals.add(romeo);
        Animals.add(spankey);
        Animals.add(bambi);

        // Container List - needed for running threads as of now
        List<Container> containers = new ArrayList<>();
        containers.add(container1);
        container1.containAnimal(bambi);

        for (Container c : containers) {
            c.runTimeLoops();
        }

        Boolean running = true;

        System.out.println("1. Exit \n2. Add Animal \n3. Check Hunger\n4. Feed\n");

        while (running == true) {
            // Output current state - Debug & State Checking
            for (Container c : containers) {
                if (c.Animals.isEmpty()) {
                    System.out.println("You lose!");
                }
            }
            System.out.println(container1.Animals.toString());
            System.out.println(Animals.toString());

            // Get user input
            System.out.println("What would you like to-do?");
            String userInput = scanner.nextLine(); 

            // Update game state (Based on user input)
            switch (userInput) {
                case "Add Animal":
                    System.out.println("What animal would you like to add?");
                    userInput = scanner.nextLine();
                    for (Animal a : Animals) {
                        if (a.Name.equals(userInput)) {
                            container1.containAnimal(a);
                        }
                    }
                    break;
                case "Exit":
                    running = false;
                case "Check Hunger":
                    for (Animal a : Animals) {
                        System.out.println(a.Name + " : " + a.HungerLevel);
                    }
                    break;
                case "Feed":
                    System.out.println("Which container would you like to feed?");
                    userInput = scanner.nextLine(); 
                    for (Container c : containers) {
                        if (c.Name.equals(userInput))
                            c.feedAll(Hay);
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
