import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class zooManagement{
    public static void main(String[] args) {

        // Object declarations!
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Animal romeo = new Animal("Romeo", 4, "Horse", "Male");
        Animal spankey = new Animal("Spankey", 5, "Donkey", "Male");
        Animal bambi = new Animal("Bambi", 2, "Deer", "Female");
        Container container1 = new Container(5, "Container1");
        Container container2 = new Container(2, "Container2");
        Food hay = new Food("Hay",100);
        Food horseCrap = new Food("Horse Crap", 50);

        // Animal list - crucial for checking
        List<Animal> Animals = new ArrayList<>();        
        Animals.add(romeo);
        Animals.add(spankey);
        Animals.add(bambi);

        // Container List - needed for running threads as of now
        List<Container> containers = new ArrayList<>();
        containers.add(container1);
        containers.add(container2);
        container1.containAnimal(bambi);

        // Foods list
        List<Food> foods = new ArrayList<>();
        foods.add(hay);
        foods.add(horseCrap);

        // Start threads and update container varibles
        for (Container c : containers) {
            if (!c.Animals.isEmpty()){
                c.hasAnimals = true;
            }
            c.runTimeLoops();
        }

        // Start lose state thread
        LoseThread loseStateRunnable = new LoseThread(containers);
        Thread loseStateThread = new Thread(loseStateRunnable);
        loseStateThread.start();

        boolean running = true;

        // Display Commands
        System.out.println("1. Exit \n2. Commands\n3. Add Animal \n4. Check Hunger\n5. Feed\n6. View Animals\n7. Rename Animal\n8. Move Animal\n9. Describe Animals");

        // Main loop
        while (running) {
            // Get user input
            System.out.println("What would you like to-do?");
            String userInput = scanner.nextLine();

            // Update game state (Based on user input)
            switch (userInput.toLowerCase()) {
                case "add animal":
                    System.out.println("What animal would you like to add?");
                    System.out.println("You have uncontained animals:");
                    for (Animal a : Animals) {
                        if (!a.isContained){
                            System.out.print(ConsoleColors.RED + a.Name + "\t" + ConsoleColors.RESET);
                        }
                    }
                    System.out.print("\n");
                    userInput = scanner.nextLine();
                    for (Animal a : Animals) {
                        if (a.Name.equalsIgnoreCase(userInput)) {
                            System.out.println("What Container Would you like to add the animal to?");
                            for (Container c : containers){
                                if (c.SpaceLeft > 0) {
                                    System.out.print(ConsoleColors.RED + c.Name + ConsoleColors.RESET);
                                    System.out.print("\t");
                                }
                            }
                            System.out.print("\n");
                            userInput = scanner.nextLine();
                            for (Container c : containers) {
                                if (c.SpaceLeft > 0){
                                    if (c.Name.equalsIgnoreCase(
                                            userInput.toLowerCase())){
                                        c.containAnimal(a);
                                        System.out.println(ConsoleColors.RED + a.Name + " has been contained in - " + c.Name + ConsoleColors.RESET);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "exit":
                    System.exit(1);
                case "check hunger":
                    for (Animal a : Animals) {
                        if (a.isContained){
                            System.out.println(ConsoleColors.YELLOW + a.Name + " : " + a.HungerLevel + ConsoleColors.RESET);
                        } else {
                            System.out.println(ConsoleColors.YELLOW + a.Name + " is uncontained" + ConsoleColors.RESET);
                        }
                    }
                    break;
                case "feed":
                    // Check Container to feed
                    String containerToFeed = "";
                    System.out.println(ConsoleColors.CYAN + "What container would you like to feed?" + ConsoleColors.RESET);
                    for (Container c : containers){
                        System.out.print(ConsoleColors.CYAN + c.Name + ConsoleColors.RESET);
                        System.out.print("\t");
                    }
                    System.out.print("\n");
                    userInput = scanner.nextLine();
                    for (Container c : containers){
                        if (userInput.equalsIgnoreCase(c.Name)){containerToFeed = c.Name;}
                    }
                    // Check which food to use
                    String foodToUse = "";
                    System.out.println(ConsoleColors.CYAN + "What food would you like to use?" + ConsoleColors.RESET);
                    for (Food f : foods){
                        System.out.print(ConsoleColors.CYAN + f.FoodName + ConsoleColors.RESET);
                        System.out.print("\t\t");
                    }
                    System.out.print("\n");
                    userInput = scanner.nextLine();
                    for (Food f : foods){
                        if (userInput.equalsIgnoreCase(f.FoodName)) {foodToUse = f.FoodName;}
                    }
                    // Feed container with said food
                    for (Container c : containers) {
                        if (c.Name.equalsIgnoreCase(containerToFeed)) {
                            for (Food f : foods) {
                                if (f.FoodName.equalsIgnoreCase(foodToUse)){
                                    c.feedAll(f);
                                }
                            }
                        }
                    }
                    containerToFeed = "";
                    foodToUse = "";
                    break;
                case "view animals":
                    for (Animal a : Animals){
                        System.out.println(ConsoleColors.PURPLE + a.Name + " - Contained in: " + a.BoxContained + ConsoleColors.RESET);
                    }
                    break;
                case "commands":
                    // Reprints Commands
                    System.out.println(ConsoleColors.GREEN + "1. Exit \n2. Commands\n3. Add Animal \n4. Check Hunger\n5. Feed\n6. View Animals" + ConsoleColors.RESET);
                    break;
                case "rename animal":
                    String animalNameToChange = "";
                    System.out.println(ConsoleColors.BLUE + "What Animal would you like to rename?" + ConsoleColors.RESET);
                    for (Animal a : Animals){
                        System.out.print(ConsoleColors.BLUE + a.Name + "    " + ConsoleColors.RESET);
                    }
                    System.out.print("\n");
                    userInput = scanner.nextLine();
                    for (Animal a : Animals){
                        if (a.Name.equalsIgnoreCase(userInput)){
                            animalNameToChange = a.Name;
                        }
                    }
                    System.out.println(ConsoleColors.BLUE + "What would you like to rename your animal to?" + ConsoleColors.RESET);
                    userInput = scanner.nextLine();
                    for (Animal a : Animals){
                        if (a.Name.equalsIgnoreCase(animalNameToChange)){
                            a.changeName(userInput);
                        }
                    }
                    System.out.println(ConsoleColors.BLUE + "You changed " + animalNameToChange + " to " + userInput + ConsoleColors.RESET);
                    animalNameToChange = "";
                    break;
                case "move animal":
                    // Thank you stack overflow genius for teaching me about Java pointers!
                    Animal animalToMovePointer = null;
                    Container sourceContainerPointer = null;
                    Container destinationContainerPointer = null;

                    System.out.println(ConsoleColors.YELLOW + "What animal would you like to move?" + ConsoleColors.RESET);
                    for (Animal a : Animals) {
                        System.out.print(ConsoleColors.YELLOW + a.Name + "  " + ConsoleColors.RESET);
                    }
                    System.out.print("\n");
                    String animalName = scanner.nextLine();

                    for (Container c : containers) {
                        for (Animal a : c.Animals) {
                            if (a.Name.equalsIgnoreCase(animalName)) {
                                animalToMovePointer = a;
                                sourceContainerPointer = c;
                                break;
                            }
                        }
                        if (animalToMovePointer != null) {
                            break;
                        }
                    }

                    // Uh where dat animal duuude! Throws oh crap (error) when animal not found
                    if (animalToMovePointer == null) {
                        System.out.println(ConsoleColors.RED + "Couldn't find animal named'" + animalName + ConsoleColors.RESET);
                        break;
                    }

                    System.out.println(ConsoleColors.YELLOW + "What container would you like to move " + animalToMovePointer.Name + " to?" + ConsoleColors.RESET);
                    for (Container c : containers) {
                        System.out.print(ConsoleColors.YELLOW + c.Name + "  " + ConsoleColors.RESET);
                    }
                    System.out.print("\n");
                    String containerName = scanner.nextLine();

                    for (Container c : containers) {
                        if (c.Name.equalsIgnoreCase(containerName)) {
                            destinationContainerPointer = c;
                            break;
                        }
                    }

                    if (destinationContainerPointer == null) {
                        System.out.println(ConsoleColors.RED + "Error: Container '" + containerName + "' not found. Please try again." + ConsoleColors.RESET);
                        break;
                    }

                    // Logic dance! Add the animal to container :)
                    if (sourceContainerPointer != null) {
                        sourceContainerPointer.removeAnimal(animalToMovePointer);
                    } else { System.out.println("Debug - I dont trust my coding skills so i added this debug line"); }

                    destinationContainerPointer.containAnimal(animalToMovePointer);
                    System.out.println(ConsoleColors.GREEN + "Successfully moved " + animalToMovePointer.Name + " to " + destinationContainerPointer.Name + ConsoleColors.RESET);
                    break;
                case "describe animals":
                    for (Animal a : Animals){
                        System.out.println(a.toString());
                    }
                    break;
                case "make new animal":
                    // This is a debugging command and will not be added to command list!
                    System.out.println("This is highly experimental!");
                    System.out.print("Name: ");
                    String newAnimalName = scanner.nextLine();
                    System.out.print("Species: ");
                    String newAnimalSpecies = scanner.nextLine();
                    int newAniamlAge = random.nextInt(1, 5);
                    Animal newAnimal = new Animal(newAnimalName,newAniamlAge, newAnimalSpecies, "Male");
                    Animals.add(newAnimal);
                    newAnimalName = "";
                    newAnimalSpecies = "";
                    break;
                default:
                    System.out.println("Function Not-Found - " + userInput);
                    break;
            }
        }
    scanner.close();
    }
}
