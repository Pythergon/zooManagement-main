import java.util.List;

public class LoseThread implements Runnable {
    private List<Container> containers;

    // Constructor to receive the list of containers
    public LoseThread(List<Container> containerList) {
        this.containers = containerList;
    }

    @Override
    public void run() {
    // Runs logic to see if all animals died of hunger or uncontained!
        while (true) {
            try {
                Boolean hasSomeAnimals = false;
                Thread.sleep(100); // Sleep for 100 milliseconds
                for (Container c : containers) {
                    if (c.hasAnimals) {
                        hasSomeAnimals = true;
                        break;
                    }
                }
                if (!hasSomeAnimals) {
                    System.out.println("You Lose!");
                    System.out.println("All animals got lost or starved");
                    System.exit(1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("MyThreading was interrupted.");
                break;
            } catch (Exception e) {
            }
        }
    }
}