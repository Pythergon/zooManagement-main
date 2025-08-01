import java.util.List;

public class MyThreading implements Runnable{
    public void run() {
        System.out.println("Hello!");
    }

    public void runLoop(List<Container> containerList) {
        while(true) {
            try {
                Boolean hasSomeAnimals = false;
                Thread.sleep(100);
                for (Container c : containerList) {
                    if (c.hasAnimals) {hasSomeAnimals = true;}
                }
                if (!hasSomeAnimals) {
                    System.out.println("You Lose!");
                    System.out.println("All animals got lost or starved");
                    System.exit(1);
                }
            } catch (Exception e) {
            }
        }
    }
}
