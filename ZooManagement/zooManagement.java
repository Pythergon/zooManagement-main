import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooManagement {
    public static void main(String[] args) {

        // Object declarations!
        Scanner scanner = new Scanner(System.in);
        animal romeo = new animal("Romeo", 4, "Horse");
        animal spankey = new animal("Spankey", 5, "Donkey");
        animal bambi = new animal("Bambi", 2, "Deer");
        container container1 = new container(2, "Container1");
        food Hay = new food("Hay",10);

        // Animal list - crucial for checking
        List<animal> Animals = new ArrayList<>();        
        Animals.add(romeo);
        Animals.add(spankey);
        Animals.add(bambi);

        List<container> containers = new ArrayList<>();
        containers.add(container1);
        container1.containAnimal(bambi);

        for (animal a : Animals) {
            a.getHungry();
        }

        Boolean running = true;

        System.out.println("1. Exit \n2. Add Animal \n3. Check Hunger\n");

        while (running) {
            // Output current state
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
                    for (animal a : Animals) {
                        if (a.Name.equals(userInput)) {
                            container1.containAnimal(a);
                        }
                    }
                    break;
                case "Exit":
                    running = false;
                case "Check Hunger":
                    for (animal a : Animals) {
                        System.out.println(a.Name + " : " + a.HungerLevel);
                    }
                case "Feed":
                    System.out.println("Which container would you like to feed?");
                    userInput = scanner.nextLine(); 
                    for (container c : containers) {
                        if (c.Name.equals(userInput))
                            c.feedAll(Hay);
                    }

                default:
                    System.out.println("Function Not-Found");
                    break;
            }   

            //running = false;
        }
        scanner.close();
    }
}
