import java.util.List;

public class MyThreading implements Runnable {
    private List<Container> containers;

    // Constructor to receive the list of containers
    public MyThreading(List<Container> containerList) {
        this.containers = containerList;
    }

    @Override
    public void run() {
        // Now, the logic from your original runLoop is inside the run() method
        while (true) {
            try {
                Boolean hasSomeAnimals = false;
                Thread.sleep(100); // Sleep for 100 milliseconds
                for (Container c : containers) { // Use the instance variable 'containers'
                    if (c.hasAnimals) {
                        hasSomeAnimals = true;
                        break; // No need to check other containers if one has animals
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
                System.err.println("An unexpected error occurred in MyThreading: " + e.getMessage());
            }
        }
    }
}