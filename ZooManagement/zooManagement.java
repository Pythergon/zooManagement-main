public class zooManagement {
    public static void main(String[] args) {
        animal Romeo = new animal("Romeo", 4, "Horse");
        animal Spankey = new animal("Spankey", 5, "Donkey");
        animal Bambi = new animal("Bambi", 2, "Deer");
        container Conatainer1 = new container(2);
        food Hay = new food("Hay",10);

        Spankey.hungerLevel = 2;
        Spankey.containAnimal(Conatainer1, Spankey);
        Romeo.containAnimal(Conatainer1, Romeo);
        Bambi.containAnimal(Conatainer1, Bambi); 
        
        Conatainer1.feedAll(Hay);
        // System.out.println(Hay.quantity);
        System.out.println(Conatainer1.spaceLeft);
        System.out.println(Spankey.toString());
    }
}
