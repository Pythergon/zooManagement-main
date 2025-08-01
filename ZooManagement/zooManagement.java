import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zooManagement extends Thread{
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

        Boolean running = true;

        System.out.println("1. Exit \n2. Add Animal \n3. Check Hunger\n4. Feed\n");

        while (running == true) {
            System.out.println(container1.Animals.toString());
            System.out.println(Animals.toString());

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
                            System.out.printf(" %s ", a.Name); 
                        }
                    }
                    System.out.print("\n");
                    userInput = scanner.nextLine();
                    for (Animal a : Animals) {
                        if (a.Name.equals(userInput)) {
                            for (Container c : containers){
                                System.out.printf("What container would you like to add %s to? \n", userInput);
                                if (c.SpaceLeft > 0){
                                    System.out.print(c.Name);
                                    System.out.print("\n");
                                    userInput = scanner.nextLine();
                                    if (c.Name.equals(userInput)){
                                        c.containAnimal(a);
                                    }
                                }
                            }
                            container1.containAnimal(a);
                        }
                    }
                    break;
                case "Exit":
                    System.exit(1);
                case "Check Hunger":
                    for (Animal a : Animals) {
                        if (a.isContained){
                            System.out.println(a.Name + " : " + a.HungerLevel);
                        } else {
                            System.out.println(a.Name + " is uncontained");
                        }
                    }
                    break;
                case "Feed":
                    System.out.println("Which container would you like to feed?");
                    userInput = scanner.nextLine();
                    System.out.println("You have foods:");
                    for (Food f : foods){
                        System.out.println(f.FoodName);
                    } 
                    for (Container c : containers) {
                        if (c.Name.equals(userInput))
                            for (Food f : foods) {
                                System.out.println("What food would you like to use");
                                userInput = scanner.nextLine();
                                if (f.FoodName.equals(userInput)){
                                    c.feedAll(f);
                                }
                            }
                    }
                    break;
                default:
                    System.out.println("Function Not-Found - " + userInput);
                    break;
            }   

            //running = false;
        }
    scanner.close();
    }
}
