import java.util.Random;

public class animal {
    public String name;
    public int age;
    public String species;
    public int hungerLevel = 0; // 0-5

    public boolean isContained = false;

    public animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public void changeHunger(int newHunger){
        this.hungerLevel = newHunger;
    }

    public void getHungry() {
        Random random = new Random();
        int DURATION_IN_SECONDS = (random.nextInt(5) + 1) * 60; 

        // System.out.println("Debug : Timer started for " + this.name);

        Thread timerThread = new Thread(() -> {
            
            while (true){
                try {
                    Thread.sleep(DURATION_IN_SECONDS * 1000);
                    this.changeHunger(this.hungerLevel + 1);
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
        return String.format("%s is a %d year old %s", this.name, this.age, this.species);
    }

}
