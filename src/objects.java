import java.util.ArrayList;

public class objects {
    static player Player = new player();
    static ArrayList<encounters> Encounters = new ArrayList<encounters>();
    static ArrayList<monsters> monstersDB = new ArrayList<monsters>();
    static ArrayList<items> itemsDB = new ArrayList<items>();
    // ArrayList<encounters> encountersDB = new ArrayList<encounters>();
    public static void initializeMonstersArray() {
        monstersDB.add(new monsters());
        monstersDB.add(new wolves());
    }
    public static void intitializeItemsArray() {
        itemsDB.add(new items());
        itemsDB.add(new staff());
        itemsDB.add(new ring());
        itemsDB.add(new hawk());
    }
    public static void initializeEncountersArray() {
        Encounters.add(new encounters(0));
        Encounters.add(new encounters(1));
        Encounters.add(new encounters(2));
        
    }
}
