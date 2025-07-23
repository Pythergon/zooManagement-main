import java.util.Random;

public class animal {
    public String Name;
    public int Age;
    public String Species;
    public int HungerLevel = 0; // 0-5

    public boolean isContained = false;

    public animal(String Name, int Age, String Species) {
        this.Name = Name;
        this.Age = Age;
        this.Species = Species;
    }

    public void changeHunger(int newHunger){
        this.HungerLevel = newHunger;
    }

    public void getHungry() {
        Random random = new Random();
        int DURATION_IN_SECONDS = (random.nextInt(5) + 1) * 60; 

        // System.out.println("Debug : Timer started for " + this.Name);

        Thread timerThread = new Thread(() -> {
            
            while (true){
                try {
                    Thread.sleep(DURATION_IN_SECONDS * 1000);
                    this.changeHunger(this.HungerLevel + 1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }   
            }
        });

        timerThread.setName("HungryTimerThread");
        timerThread.start();
    }

    @Override
    public String toString() {
        return String.format("%s is a %d year old %s", this.Name, this.Age, this.Species);
    }

}
