public class zooManagement {
    public static void main(String[] args) {
        animal Romeo = new animal("Romeo", 4, "horse");
        animal Spankey = new animal("Spankey", 5, "Donkey");
        container Conatainer1 = new container(2);
        food Hay = new food("Hay",10);

        Spankey.hungerLevel = 2;
        Spankey.containAnimal(Conatainer1, Spankey);
        Romeo.containAnimal(Conatainer1, Romeo);
        
        Conatainer1.feedAll();
        // System.out.println(Spankey.hungerLevel);
        System.out.println(Conatainer1.spaceLeft);
        Spankey.describe();
        // System.out.println(Conatainer1.animals);
    }
}
