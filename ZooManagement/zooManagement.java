import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooManagement{
    public static void main(String[] args) {

        // Object declarations!
        Scanner scanner = new Scanner(System.in);
        Animal romeo = new Animal("Romeo", 4, "Horse");
        Animal spankey = new Animal("Spankey", 5, "Donkey");
        Animal bambi = new Animal("Bambi", 2, "Deer");
        Container container1 = new Container(2, "Container1");
        Container container2 = new Container(1, "Container2");
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

        for (Container c : containers) {
            if (!c.Animals.isEmpty()){
                c.hasAnimals = true;
            }
            c.runTimeLoops();
        }

        MyThreading loseStateRunnable = new MyThreading(containers);
        Thread loseStateThread = new Thread(loseStateRunnable);
        loseStateThread.start();

        boolean running = true;

        System.out.println("1. Exit \n2. Commands\n3. Add Animal \n4. Check Hunger\n5. Feed\n6. View Animals");

        while (running) {
            // Get user input
            System.out.println("What would you like to-do?");
            String userInput = scanner.nextLine(); 

            // Update game state (Based on user input)
            switch (userInput) {
                case "Add Animal":
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
                        if (a.Name.equals(userInput)) {
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
                                    if (c.Name.equals(userInput)){
                                        c.containAnimal(a);
                                        System.out.println(ConsoleColors.RED + a.Name + " has been contained in - " + c.Name + ConsoleColors.RESET);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "Exit":
                    System.exit(1);
                case "Check Hunger":
                    for (Animal a : Animals) {
                        if (a.isContained){
                            System.out.println(ConsoleColors.YELLOW + a.Name + " : " + a.HungerLevel + ConsoleColors.RESET);
                        } else {
                            System.out.println(ConsoleColors.YELLOW + a.Name + " is uncontained" + ConsoleColors.RESET);
                        }
                    }
                    break;
                case "Feed":
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
                        if (userInput.equals(c.Name)){containerToFeed = c.Name;}
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
                        if (userInput.equals(f.FoodName)) {foodToUse = f.FoodName;}
                    }
                    // Feed container with said food
                    for (Container c : containers) {
                        if (c.Name.equals(containerToFeed)) {
                            for (Food f : foods) {
                                if (f.FoodName.equals(foodToUse)){
                                    c.feedAll(f);
                                }
                            }
                        }
                    }
                    break;
                case "View Animals":
                    for (Animal a : Animals){
                        System.out.println(ConsoleColors.PURPLE + a.Name + " - Contained in: " + a.BoxContained + ConsoleColors.RESET);
                    }
                    break;
                case "Commands":
                    System.out.println(ConsoleColors.GREEN + "1. Exit \n2. Commands\n3. Add Animal \n4. Check Hunger\n5. Feed\n6. View Animals" + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println("Function Not-Found - " + userInput);
                    break;
            }
        }
    scanner.close();
    }
}
