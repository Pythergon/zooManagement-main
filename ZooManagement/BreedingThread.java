import java.util.List;

/*
    Breeding loop!
    Will make a new animal if two animals in a container meet a certain condition

    Conditions -
    Need more space in container
    Hunger under 3
    Different Genders
*/


public class BreedingThread implements Runnable{
    private List<Container> containers;

    public BreedingThread(List<Container> containerList){
        this.containers = containerList;
    }

    @Override
    public void run() {
        while (true){
            try {
                for (Container c : containers){
                    if (c.SpaceLeft >= 1 && c.Animals.size() > 2){
                        for (Animal a : c.Animals){
                            break;
                            // Still very much a work in progress!
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}